package com.jioc.handler;


import com.jioc.exceptions.BusinessException;
import com.jioc.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionReslover implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object target, Exception ex) {
        ModelAndView mv = new ModelAndView();
        //默认信息
        mv.setViewName("error");// 设置默认错误页面
        mv.addObject("ex",ex);

        /***
         * 区分异常 ParamsException  BusinessException
         * */
        if (ex instanceof ParamsException){
            System.out.println("ParamsException ...");
            ParamsException e = (ParamsException)ex;
            mv.addObject("ex",e.getMsg());
            mv.setViewName("paramsError");
        }

        if(ex instanceof BusinessException){
            System.out.println("BusinessException ...");
            BusinessException e = (BusinessException)ex;
            mv.addObject("ex",e.getMsg());
            mv.setViewName("businessError");
        }
        return mv;
    }

    public static void main(String[] args) {

        Exception e1 = new ParamsException(300);

        System.out.println(e1 instanceof ParamsException);

        System.out.println(e1 instanceof BusinessException);

        System.out.println(e1 instanceof Exception);

    }

}

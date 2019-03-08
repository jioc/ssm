package com.shsxt.base;

import com.shsxt.exceptions.BusinessException;
import com.shsxt.exceptions.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    @ExceptionHandler
    public String perHandle(HttpServletRequest request,HttpServletResponse response, Exception ex){
        if (ex instanceof ParamsException){
            ParamsException e = (ParamsException)ex;
            request.setAttribute("ex",e.getMsg());
            return "paramsError";
        }

        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            request.setAttribute("ex", e.getMsg());
            return "businessError";
        }

        request.setAttribute("ex",ex.getMessage());//默认错误信息
        return  "error";//默认错误页面
    }


}

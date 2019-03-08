package com.jioc.controller;


import com.jioc.exceptions.BusinessException;
import com.jioc.exceptions.ParamsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ex")
public class ExceptionController {

    @RequestMapping("test01")
    @ResponseBody
    public String test01(){
        if (true){
            throw  new ParamsException(300,"参数为空");
        }
        return  "hello exception";
    }

    @RequestMapping("test02")
    @ResponseBody
    public String test02() {
        if (true) {
            throw new RuntimeException("运行异常");
        }
        return "hello exception";
    }

    @RequestMapping("test03")
    @ResponseBody
    public String test03() {
        if (true) {
            throw new BusinessException(305, "业务异常...");
        }
        return "hello exception";
    }
}

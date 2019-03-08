package com.shsxt.exceptions;

/**
 * Created by xlf on 2018/11/9.
 */
public class BusinessException extends RuntimeException {

    private Integer code;
    private String msg;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(Integer code) {
        super("业务异常");
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

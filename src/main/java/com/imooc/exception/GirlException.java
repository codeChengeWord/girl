package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * 自定义异常处理类
 */
public class GirlException extends RuntimeException{
    /**错误编码*/
    private  Integer code;

    public Integer getCode() {
        return code;
    }

    /**
     * 构造方法
     * @param code
     * @param massage
     */
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessge());
        this.code=resultEnum.getCode();
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}

package com.imooc.handle;

import com.imooc.Utils.ResultUtil;
import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一的异常捕获的类
 */
@ControllerAdvice
public class ExceptionHandle {
    //打印日志
    private  final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    /**
     * 捕获异常的方法
     * @ExceptionHandler声明要捕获的异常类型
     * @ResponseBody 返回json格式数据
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        /**判断当前抛出的异常是不是自定义的异常*/
        if(e instanceof GirlException) {
            GirlException girlException =  (GirlException)e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        //通过打印日志获取异常信息
        logger.error("【系统异常】 {}",e);
        return ResultUtil.error(-1,"未知错误！！");
    }
}

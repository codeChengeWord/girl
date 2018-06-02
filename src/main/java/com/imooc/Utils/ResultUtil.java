package com.imooc.Utils;

import com.imooc.domain.Result;

/**
 * 工具类
 */
public class ResultUtil {
    /**
     * 请求成功调用的方法
     * @param object
     * @return
     */
    public  static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public  static Result success(){
        return success(null);
    }

    /**
     * 失败调用的方法
     * @param code 状态吗
     * @param msg 错误信息
     * @return
     */
    public static Result error( Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

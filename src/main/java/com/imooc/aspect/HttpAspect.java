package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP处理
 * @Aspect 表示是一个AOP处理类
 * @Component 将文件引入Spring容器当中
 */
@Aspect
@Component
public class HttpAspect {
    //Spring自带的日志打印的类
    private  final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * 定义一个切点
     * execution(public * com.imooc.controller.GirlController.girlList(..))
     *  表示拦截GirController中的GirlList方法
     * execution(public * com.imooc.controller.GirlController.*(..))
     *  表示拦截GirlController中的所有方法
     */
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public  void log(){
    }
    /**
     * @Before在进入controller之前会执行该方法
     * log()对切点的引用
     * joinPoint 获取请求参数
     */
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        //记录Http请求
        //获取请求的信息
       ServletRequestAttributes attributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       //获取HttpServletRequest对象
        HttpServletRequest  request =  attributes.getRequest();
       //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("Ip={}",request.getRemoteAddr());
        //请求的类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    /**
     * @After在进入controller之前会执行该方法
     *log()对切点的引用
     */
    @After("log()")
    public  void doAfter(){
        logger.info("222222222222222");
    }

    /**
     *  @AfterReturning用来获取请求的返回
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public  void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}

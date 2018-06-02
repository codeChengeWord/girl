package com.imooc.controller;

import com.imooc.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController=@Controller+@ResponseBody
@Controller
@ResponseBody
public class HelloController {
    //使用yml文件中的变量,在配置文件中不需要关注数据类型
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    //配置文件中使用配置文件
    @Value("${content}")
    private String content;
    //通过依赖注入的方式
    @Autowired
    private GrilProperties grilProperties;
    //多个映射路径可以写成集合
    @RequestMapping(value = {"/hello","hi"},method = RequestMethod.GET)
    public  String hello(){
        return grilProperties.getCupSize()+grilProperties.getAge();
    }
    /*@RequestMapping(value = "/index",method = RequestMethod.GET)
    public  String index(){
        return "index";
    }
*/
    /**
     * @RequestParam 获取URL中的参数
     * value 参数的名称
     * required 是否必传，默认为true
     * defaultValue 参数的默认值，需是字符型的
     * @param id
     * @return
     */
   // @RequestMapping(value = "/index",method = RequestMethod.GET)
    @GetMapping(value = "/index") //相当于get请求的注解还有对应的post
    public  String indexParam(@RequestParam(value = "id" ,required = false ,defaultValue = "0") Integer id){
        return "index";
    }
}

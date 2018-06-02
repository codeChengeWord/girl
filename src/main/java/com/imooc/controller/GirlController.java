package com.imooc.controller;

import com.imooc.Utils.ResultUtil;
import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.resository.GirlRepository;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 女孩的controller
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        //获取所有的女孩
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     * @Valid 可以配合对象中的注解进行表单验证
     * bindingResult 获取校验后的信息
     */
    @PostMapping(value = "/addGirl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        //判断校验是否通过
        if(bindingResult.hasErrors()){
            //获取校验的错误信息
            String error = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(0,error);
        }
        //保存女孩对象到数据库
        return ResultUtil.success(girlRepository.save(girl));
    }
    @GetMapping(value = "/girls/getAge/{id}")
    public  void getAge(@PathVariable("id") Integer id) throws  Exception{
        girlService.getAge(id);
    }
}

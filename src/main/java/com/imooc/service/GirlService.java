package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.resository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 服务层
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional//事务控制注解添加该注解对方法中进行事务大的控制
    public void savaGirl(){

    }
    public  void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age =  girl.getAge();
        if(age<10){
            //小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            //中学
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return  girlRepository.getOne(id);
    }
}

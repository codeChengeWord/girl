package com.imooc;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 对于Service进行测试
 * @RunWith表示需要在测试环境中运行了
 * @SpringBootTest将启动整个工程
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public  void findOneTest(){
        Girl girl = girlService.findOne(3);
        //进行断言
        Assert.assertEquals(new Integer(12),girl.getAge());
    }
}

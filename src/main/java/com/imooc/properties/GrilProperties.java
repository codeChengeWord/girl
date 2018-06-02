package com.imooc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 女孩配置类
 * 能够映射对应配置文件中的grill前缀的属性
 * 创建BEN需要添加@Component
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GrilProperties {
    private  String cupSize;
    private  Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

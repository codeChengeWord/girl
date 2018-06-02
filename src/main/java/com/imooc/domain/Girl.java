package com.imooc.domain;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 女孩实体
 * @Entity 表示这是一个数据实体
 * @Proxy 是否懒加载
 */
//@Proxy(lazy = false)
@Entity
public class Girl {
    /**
     * @Id 指定表的主键
     * @GeneratedValue 指定主键自增
     */
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    /**
     * 表单验证注解配合@Valid注解使用
     */
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;
    /**
     * @NotEmpty 内容非空验证
     * @Length内容长度验证
     */
    @NotEmpty(message = "金额必填")
    @Length(max = 5,message = "金额长度不能大于5")
    private double money;

    public Girl() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}

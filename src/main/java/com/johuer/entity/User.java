package com.johuer.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author xujiuhua
 * @create 2016-10-21-15:56
 */
public class User implements Serializable{

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "性别")
    private String sex ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

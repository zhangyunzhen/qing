package com.zyz.serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 13:54 2019/4/8
 */
public class TestBean {

    //@JsonIgnore
    private String name;

    private Integer age;

    public TestBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

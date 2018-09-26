package com.sunshine.entity;

import java.io.Serializable;

/**
 * @Package:   com.sunshine 
 * @ClassName: MsgEntity
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class MsgEntity implements Serializable {
    private String name;
    private int age;

    public MsgEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "MsgEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

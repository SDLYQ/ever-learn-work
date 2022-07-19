package com.ever.servicesentinelcore.pojo;

/**
 * @author xpr
 * @create 2022/6/8
 */
public class User {
    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private String name;

    private int age;

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
}

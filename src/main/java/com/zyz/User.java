package com.zyz;

import com.alibaba.fastjson.JSON;

public class User implements Cloneable {
    protected int id;
    private String name;

    private boolean a;

    public User() {
    }

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


    public static void main(String[] args) {
        User user = new User();
        System.out.println(JSON.toJSONString(user));
    }
    @Override
    public User clone(){
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 这是浅度复制  如果该类成员变量有其他对象的引用，那需要对该成员变量也clone.
        return user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }
}

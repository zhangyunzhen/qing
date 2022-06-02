/*
 * 文件名：User.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月2日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;

import com.alibaba.fastjson.JSON;

public class User {

    private String username;
    
    private String userpwd;

    public User() {

    }

    public static void a(User user){
        System.out.println("我是User静态方法"+ JSON.toJSONString(user));
    }

    public  void b(){
        System.out.println("我是User成员方法");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public User(String userpwd) {
        super();
        this.userpwd = userpwd;
    }
    
}

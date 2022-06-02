/*
 * 文件名：DefauMethImp.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;

import com.alibaba.fastjson.JSON;

import java.util.function.Supplier;

public class DefauMethImp implements DefaultMethodInterf {

    @Override
    public void test() {

    }

    public void methodRef(Supplier<User> user) {
        System.out.println(JSON.toJSONString(user.get()));
    }

}

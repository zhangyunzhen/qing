package com.zyz.jvm.monitor;

import com.google.common.collect.Lists;
import com.zyz.User;

import java.util.List;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/04/10
 */
public class JConsoleAnalyze {


    public static void main(String[] args) throws InterruptedException {
        List<User> users = Lists.newArrayList();
        while (true) {
            User user = new User();
            user.setId(11);
            user.setName("asdasd");
            users.add(user);
            Thread.sleep(10L);
            System.out.println(users.size());
        }
    }
}

package com.zyz.jvm.monitor;

import com.zyz.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: YunzhenZhang
 * @Description: 构造堆溢出
 * @Date: Created in 19:51 2018/7/29
 */
public class OOM {


    private List<User> userList = new ArrayList<User>();
    private List<Class<?>> classList = new ArrayList<Class<?>>();

    /**
     * -Xmx32M -Xms32M
     */
    @Test
    public void heap() {
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }


    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * */
/*    public String nonheap() {
        while(true) {
            classList.addAll(User.createClasses());
        }
    }*/
}

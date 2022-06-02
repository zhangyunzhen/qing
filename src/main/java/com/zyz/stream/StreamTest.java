/*
 * 文件名：StreamTest.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.zyz.java8Demo.User;


public class StreamTest {

    /**
     * 使用： stream的map方法
     * 实现功能：将User的密码全部转化为大写
     * @see
     */
    @Test
    public void  testMap() {
        List<User> asList = Arrays.asList(new User("qwe"),
            new User("zxc"), 
            new User("zvsdrgf"),
            new User("poiu"),
            new User("123"));
        Stream<User> stream = asList.stream();
        stream.map(p -> {p.setUserpwd(p.getUserpwd().toUpperCase());
            return p;
        }).forEach(p -> System.out.println(p.getUserpwd()));;
        
    }
}

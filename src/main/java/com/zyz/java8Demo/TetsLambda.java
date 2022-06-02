/*
 * 文件名：TetsLambda.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月2日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;


/**
 *  lamda基础语法：
 *              引入新的操作符“->”。该操作符称为箭头操作符或lambda操作符。
 *              箭头操作符将lamda表达式分为左右两部分。
 *       左侧：为表达式的参数列表。
 *       右侧：表达式中所需要执行的功能，即lamda体。
 *    
 *    语法格式一：  无参数无返回值
 *              () -> System.out.println("")
 *    语法格式二：  有一个参数无返回值（若只有一个参数，小括号可以不写）
 *              p -> System.out.println(p)
 *    语法格式三：  有两个以上参数，有多条执行语句，有返回值        
 *              (User p,User q) -> {
 *                 return p.getUserpwd().compareTo(q.getUserpwd());
 *              }
 *    语法格式四： 执行语句和返回值为一条语句，可以省去大括号和“return”
 *              (User p,User q) ->  p.getUserpwd().compareTo(q.getUserpwd())
 * @author zhangyunzhen
 * @version 2018年1月2日
 * @see TetsLambda
 * @since
 */
public class TetsLambda {

    /**
     *  语法格式一：无参数无返回值
     * @see
     */
    @Test
    public void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是原生线程一");
            }
        }).start();

        System.out.println("===========================");

        new Thread(() -> System.out.println("我是lambda实现")).start();
    }

    /**
     * 有一个参数无返回值
     * @see
     */
    @Test
    public void test2() {
        Consumer<Integer> con = p -> System.out.println(p);
        con.accept(2);
    }

    /**
     * 有两个参数并有返回值
     * @see
     */
    @Test
    public void test3() {
        List<User> list = new ArrayList<>();
        list.add(new User("abc"));
        list.add(new User("d"));
        list.add(new User("b"));
        list.add(new User("ab"));
        list.add(new User("abcd"));
        /*  Collections.sort(list,(User p,User q) -> {
          return p.getUserpwd().compareTo(q.getUserpwd());
          });*/

        Collections.sort(list, (User p, User q) -> p.getUserpwd().compareTo(q.getUserpwd()));
        for (User user : list) {
            System.out.println(user.getUserpwd());
        }
    }
}

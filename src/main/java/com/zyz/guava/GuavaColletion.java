package com.zyz.guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: YunzhenZhang
 * @Description: guava集合工具类
 * @Date: Created in 11:50 2018/5/13
 */
public class GuavaColletion {

    public final List<String> list = Lists.newArrayList();

    public List<Integer> list1;

    public static final String test;

    static {
        test = "a";
    }

    @Before
    public void listCreate() {
        //list = Arrays.asList("a", "c", "b", "d", "e", "f");
        list1 = Arrays.asList(1, 6, 3, 4, 9, 7);
    }

    /**
     * 查找集合中的某个元素索引
     */
    @Test
    public void testFind() {
        //二分查找
        int f = Collections.binarySearch(list, "f");
        System.out.println(list.get(f));
    }

    /**
     * 将list排列
     */
    @Test
    public void mixList() {
        Collections.shuffle(list);
        for (String string : list) {
            System.out.println(string);
        }
    }

    /**
     * 排序
     */
    @Test
    public void sort() {
    /*    //默认从小到大排序
        Collections.sort(list);
        System.out.println(list);
*/
        //从大到小排序
        Collections.sort(list1, (p1, p2) -> p1 > p2 ? -1 : 0);
        System.out.println(list1);
    }

    /**
     * 翻转遍历
     */
    @Test
    public void reverse() {
        List<String> reverse = Lists.reverse(list);
        System.out.println(reverse);
    }

    /**
     * 转换
     */
    @Test
    public void transform() {
        List<String> transform = Lists.transform(list, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "a";
            }
        });
        System.out.println(transform);
    }



    final class A {
        public final String a;

        A(String a) {
            this.a = a;
        }
    }
}

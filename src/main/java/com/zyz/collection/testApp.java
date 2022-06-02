package com.zyz.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 15:51 2018/9/8
 */
public class testApp {


    @Test
    public void test() {
        List<String> list = Lists.newArrayList("a", "b", "d", "v");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (StringUtils.equalsIgnoreCase(next, "a")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }


    @Test
    public void test1() {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("张三", 1);
        linkedHashMap.put("李四", 2);
        linkedHashMap.put("王武", 3);
        linkedHashMap.put("求求", 4);
        linkedHashMap.put("哈哈哈", 4);
        linkedHashMap.put("xixi", 4);
        linkedHashMap.put("阿斯顿", 4);

        Object aa = linkedHashMap.get("求求");
        System.out.print(aa);
        System.out.println();

        Set<Map.Entry<Object, Object>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey());
        }
    }


}




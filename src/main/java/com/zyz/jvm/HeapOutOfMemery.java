/*
 * 文件名：HeapOutOfMemery.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.jvm;

import com.zyz.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 * @author zhangyunzhen
 * @version 2018年1月28日
 * @see HeapOutOfMemery
 * @since
 */
public class HeapOutOfMemery {

    /**
     * 
     * Description: <br>
     * jvm args: -Xms20m -Xmx20m 
     * 
     * @param args 
     * @see
     */
    public static void main(String[] args) throws Exception {
        List<User> list = new ArrayList<>();
        int i = 0;
        Thread.sleep(10000);
        while(true){
            list.add(new User());
            System.out.println(i++);
            throw  new Exception();
        }
    }
}

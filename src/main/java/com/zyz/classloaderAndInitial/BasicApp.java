/*
 * 文件名：ClassLoaderAndInitialTest.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年7月27日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.classloaderAndInitial;


/**
 * 基类
 * @author zhangyunzhen
 * @version 2017年7月27日
 * @see BasicApp
 * @since
 */
public class BasicApp {

    private static String basicSta;

    private String basicB;
    
    static{
        basicSta = "asd";
        System.out.println("aaa");
    }
    
    {
        basicB = "asd";
        System.out.println("bbb");
    }


    public BasicApp() {
        System.out.println("ccccc");
    }
}

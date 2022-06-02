/*
 * 文件名：ChildrenApp.java
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
 * 子类
 * @author zhangyunzhen
 * @version 2017年7月27日
 * @see ChildrenApp
 * @since
 */
public class ChildrenApp extends BasicApp {

    private static String sta;
    
    private  String a;
    
    private long bb;

    static {
        System.out.println("====");
    }

    {
        System.out.println("pppp");
    }

    public static void main(String[] args) {
        ChildrenApp app = new ChildrenApp();
    }

    public ChildrenApp() {
        System.out.println("mmmmmmmmm");
    }

    public void setBb(Long b){
        this.bb = b;
    }
}

/*
 * 文件名：App.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月15日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.enumDemo;

public class App {

   public void show(Zoo zoo){
       System.out.println(zoo.value);
   }
   
   public static void main(String[] args) {
    App app = new App();
    app.show(Zoo.fish);
   }
}


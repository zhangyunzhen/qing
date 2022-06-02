package com.zyz.jvm;

/**
 * @Author: YunzhenZhang
 * @Description:
 *     静态块数据在类加载的时候调用一次
 *     构造器在每次创建对象实例的时候调用
 *
 * @Date: Created in 17:02 2018/8/9
 */
public class ClassLoadProceed {

    public static double aa = Math.random();

    static {
        System.out.println("static block " + aa);
    }

    public ClassLoadProceed() {
        System.out.println("contructor block" + aa);
    }

    public static void main(String[] args) {
        System.out.println(aa);
        ClassLoadProceed classLoadProceed = new ClassLoadProceed();
        ClassLoadProceed classLoadProceed2 = new ClassLoadProceed();
    }

}

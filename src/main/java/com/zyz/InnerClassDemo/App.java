package com.zyz.InnerClassDemo;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 9:49 2018/8/16
 */
public class App {

    public String aaa = "";

    private String bbb;

    private static String ccc = "";

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    /**
     * 静态内部类
     *      1.不能引用外部类的成员变量
     */
    static class StaticInnerClass{
        private String a;
        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }


    /**
     * 内部类
     */
    class InnerClass{
        private String aa;
        private String bb;


        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }
    }
}

package com.zyz.jvm;

import org.junit.Test;

/**
 * @Author: YunzhenZhang
 * @Description:
 *      gc回收
 *          设置jvm参数：-Xms20M -Xmx20M -Xmn10M//新生代大小 -XX:SurvivorRatio=8 //新生代中Eden区域和一个Survivor的比例
 *      结果表明：
 *          当新生代空间不够的话，会执行gc，此时发现新生代空间还是不够，将大数组直接放入老年代中
 *
 * @Date: Created in 10:22 2018/6/19
 */
public class GcTest {

    private static final int _1MB = 1024 * 1024;

    @Test
    public void gcOperation() {
        App app = new App("aa");
        app = null;
        System.gc();
    }

    @Test
    public void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[6 * _1MB];
    }


    class App {
        private String name;

        public App(String name) {
            this.name = name;
        }
    }


}

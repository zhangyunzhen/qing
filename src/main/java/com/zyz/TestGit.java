package com.zyz;

import com.google.common.collect.Lists;


import javax.annotation.Resource;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 21:01 2018/11/13
 */
public class TestGit {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("zyz-A  first commit");
        System.out.println("zyz-B  first commit");
        System.out.println("zyz-B  first commit");
        Thread.sleep(1000000L);
    }


   // private static Timer timer = new Timer("TaskQueueMonitor", true);

    static {
    //    timer.schedule(new TestGit.MonitorTask(), 0L, 1000L);
    }

    static class MonitorTask extends TimerTask {


        @Override
        public void run() {
            System.out.println("asdasd");
        }
    }

}

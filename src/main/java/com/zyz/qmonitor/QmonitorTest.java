package com.zyz.qmonitor;

import com.google.common.base.Stopwatch;
import com.qunar.flight.qmonitor.QMonitor;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2020/04/20
 */
public class QmonitorTest {


    public static void main(String[] args) {
        QMonitor.recordOne("AAAAA");
        QMonitor.recordOne("BBBBB", 1000L);
        QMonitor.recordOne("BBBBB", 5000L);
        QMonitor.recordSize("CCCCCC", 10);
        QMonitor.recordSize("CCCCCC", 30);
        new Thread(new QmonitorThread()).start();
    }


    public static class QmonitorThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                Stopwatch started = Stopwatch.createStarted();
                for (Map.Entry<String, Object> entry : QMonitor.getValues().entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println((name + "=" + value + "\n"));
                }
                System.out.println("================================"+ new Date());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

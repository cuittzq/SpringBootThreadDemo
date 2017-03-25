package cn.tzq.threadpool.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：实现控制数量的场景，可以是线程数量或者任务数量等等
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-25 16:05
 **/
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(10);
        final AtomicInteger number = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    try {
                        semaphore.acquire();
                        number.incrementAndGet();
                    } catch (InterruptedException e) {
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
        Thread.sleep(10000);
        System.out.println("共" + number.get() + "个线程获得到信号");
        System.exit(0);
    }
}

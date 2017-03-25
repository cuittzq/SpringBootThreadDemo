package cn.tzq.threadpool.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 功能描述：这个类是为了方便的实现多个线程一起启动的场景，就像赛跑一样，只要大家都准备好了，那就开始一起冲。
 * 所有的线程都准备好了，才会一起开始执行。
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-25 16:03
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            final int number = i + 1;
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("等待执行任务[" + number + "]");
                    try {
                        try {
                            cyclicBarrier.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                    }
                    System.out.println("开始执行任务[" + number + "]");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

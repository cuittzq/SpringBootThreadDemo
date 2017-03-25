package cn.tzq.threadpool.thread;

import java.util.concurrent.Exchanger;

/**
 * 功能描述：实现两个线程交换数据的场景。
 * 两个线程在只有一个线程调用exchange方法的时候调用方会被挂起，
 * 当都调用完毕时，双方会交换数据。在任何一方没调用exchange之前，线程都会处于挂起状态。
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-25 16:07
 **/
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        final Exchanger<String> exchanger = new Exchanger<String>();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程1等待接受");
                    String content = exchanger.exchange("thread1");
                    System.out.println("线程1收到的为：" + content);
                } catch (InterruptedException e) {
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程2等待接受并沉睡3秒");
                    Thread.sleep(3000);
                    String content = exchanger.exchange("thread2");
                    System.out.println("线程2收到的为：" + content);
                } catch (InterruptedException e) {
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

package cn.tzq.threadpool.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-23 11:01
 * -------------------------------------------------------------------
 * 如果debugging是一种消灭bug的过程，那编程就一定是把bug放进去的过程。
 **/
@Component
public class ThreadPoolTaskExecutorTest {

    public void ThreadTsettwo() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.execute(new PrintTask("Thread 1"));
        taskExecutor.execute(new PrintTask("Thread 2"));
        taskExecutor.execute(new PrintTask("Thread 3"));
        taskExecutor.execute(new PrintTask("Thread 4"));
        taskExecutor.execute(new PrintTask("Thread 5"));
        // 检查活动的线程，如果活动线程数为0则关闭线程池
//        for (; ; ) {
//            int count = taskExecutor.getActiveCount();
//            System.out.println("Active Threads : " + count);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (count == 0) {
//                taskExecutor.shutdown();
//                break;
//            }
//        }
    }

}

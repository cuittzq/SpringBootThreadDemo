package cn.tzq.threadpool;

import cn.tzq.threadpool.thread.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能描述：
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-23 10:28
 * -------------------------------------------------------------------
 * 如果debugging是一种消灭bug的过程，那编程就一定是把bug放进去的过程。
 **/
public class Application {
    public static void main(String[] args) {
        // 程序启动入口
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        ThreadTsetone(ctx);
        ThreadTsettwo(ctx);
    }

    public static void ThreadTsetone(ConfigurableApplicationContext ctx) {
        PrintThread printThread1 = ctx.getBean(PrintThread.class);
        printThread1.setName("Thread 1");


        PrintThread printThread2 = ctx.getBean(PrintThread.class);
        printThread2.setName("Thread 2");

        PrintThread printThread3 = ctx.getBean(PrintThread.class);
        printThread3.setName("Thread 3");

        PrintThread printThread4 = ctx.getBean(PrintThread.class);
        printThread4.setName("Thread 4");

        PrintThread printThread5 = ctx.getBean(PrintThread.class);
        printThread5.setName("Thread 5");

        printThread1.start();
        printThread2.start();
        printThread3.start();
        printThread4.start();
        printThread5.start();
    }

    public static void ThreadTsettwo(ConfigurableApplicationContext ctx) {
        AsyncTaskService asyncTaskService = ctx.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }
}

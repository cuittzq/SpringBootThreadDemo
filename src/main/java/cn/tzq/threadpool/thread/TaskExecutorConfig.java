package cn.tzq.threadpool.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 功能描述：
 *
 * @author Tanzhiqiang
 * @mail tanzhiqiang@simpletour.com
 * @create 2017-03-23 11:33
 * -------------------------------------------------------------------
 * 如果debugging是一种消灭bug的过程，那编程就一定是把bug放进去的过程。
 **/
@Configuration
@ComponentScan("cn.tzq.threadpool")
@EnableAsync //开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {

    private Integer core_pool_size = 5;

    private Integer max_pool_size = 50;

    private Integer queue_capacity = 1000;

    private Integer keep_alive_seconds = 60;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(core_pool_size);
        taskExecutor.setMaxPoolSize(max_pool_size);
        taskExecutor.setQueueCapacity(queue_capacity);
        taskExecutor.setKeepAliveSeconds(keep_alive_seconds);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}

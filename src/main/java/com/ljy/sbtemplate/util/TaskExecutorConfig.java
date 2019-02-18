package com.ljy.sbtemplate.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * spring 线程池配置
 * @author jackson.wang
 */
@EnableAsync
@Configuration
public class TaskExecutorConfig {

    @Value("${spring.core.pool.size}")
    private int corePoolSize;

    @Value("${spring.max.pool.size}")
    private int maxPoolSize;

    @Value("${spring.queue.capacity}")
    private int queueCapacity;

    @Value("${spring.keep.alive.seconds}")
    private int keepAliveSeconds;

    @Value("${spring.thread.name.prefix}")
    private String threadNamePrefix;

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}

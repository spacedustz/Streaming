package com.streaming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {
    @Value("${thread.core-pool-size}")
    private int corePoolSize;

    @Value("${thread.max-pool-size}")
    private int maxPoolSize;

    @Value("${thread.queue-capacity}")
    private int queueCapacity;

    @Value("${thread.name-prefix}")
    private String namePrefix;

    @Bean
    @Primary
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        executor.initialize();

        return executor;
    }
}

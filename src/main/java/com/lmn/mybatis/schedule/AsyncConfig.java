package com.lmn.mybatis.schedule;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	/*
	 * 此处成员变量应该使用@Value从配置中读取
	 * 
	 * corePoolSize：线程池的基本大小
	 * maximumPoolSize：线程池中允许的最大线程数。
	 * poolSize：线程池中当前线程的数量。
	 * 当新提交一个任务时：
		（1）如果poolSize<corePoolSize，新增加一个线程处理新的任务。
		（2）如果poolSize=corePoolSize，新任务会被放入阻塞队列等待。
		（3）如果阻塞队列的容量达到上限，且这时poolSize<maximumPoolSize，新增线程来处理任务。
		（4）如果阻塞队列满了，且poolSize=maximumPoolSize，那么线程池已经达到极限，会根据饱和策略RejectedExecutionHandler拒绝新的任务。
	 * 
	 */
	private int corePoolSize = 10;
	private int maxPoolSize = 200;
	private int queueCapacity = 10;

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.initialize();
		return executor;
	}
}
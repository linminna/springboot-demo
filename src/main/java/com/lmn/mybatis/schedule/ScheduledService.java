package com.lmn.mybatis.schedule;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Async
public class ScheduledService {
	@Scheduled(cron = "0/5 * * * * *")
	public void scheduled() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + "=====>>>>>使用cron  {}" + System.currentTimeMillis());
	}

	@Scheduled(fixedRate = 5000)
	public void scheduled1() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + "=====>>>>>使用fixedRate{}" + System.currentTimeMillis());
	}

	@Scheduled(fixedDelay = 5000)
	public void scheduled2() {
		System.out.println("[" + Thread.currentThread().getName() + "]" + "=====>>>>>fixedDelay{}" + System.currentTimeMillis());
	}
}
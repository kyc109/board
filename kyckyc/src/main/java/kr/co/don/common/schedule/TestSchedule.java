package kr.co.don.common.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
	
	@Scheduled(fixedDelay = 10000*5)
	public void test() {
		log.debug("왔썹!!!!!!!!!!!!");
	}
}

package com.app.tradestoremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StoreScheduledTasksHelper {

	@Autowired
	StoreService storeService;
	/**
	 * This method is scheduled to run after every 1sec
	 * it calls updateFlag internally to update flag when maturity is expired.
	 */
	@Scheduled(fixedRate = 1000)
	public void notifyCurrentTime() {
		storeService.updateFlag();
	}
}

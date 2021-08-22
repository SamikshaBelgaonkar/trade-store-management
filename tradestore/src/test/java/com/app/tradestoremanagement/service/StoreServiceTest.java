package com.app.tradestoremanagement.service;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.tradestoremanagement.controller.StoreController;
import com.app.tradestoremanagement.model.Store;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StoreServiceTest {
	@Test
	public void contextLoads() {
	}
	@Autowired
	StoreController storeController;
	
	@Test
	public void test_storeTrade_successfull() {
		Store store = createTestDate();
		store.setMaturityDate(LocalDate.now().plusDays(2));
		ResponseEntity responseEntity = storeController.storeTrade(store);
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);
	}
	
	@Test
	public void test_storeTrade_whenLessMaturityDate() {
		String expectedErrorMsg ="Invalid Trade - either maturity date is expired or this is lower version, T1";
	Store store = createTestDate();
	store.setMaturityDate(LocalDate.now().minusMonths(3));
	store.setCreatedDate(LocalDate.now());
	try {
	ResponseEntity responseEntity  = storeController.storeTrade(createTestDate());
	}catch(RuntimeException re) {
	Assertions.assertEquals(expectedErrorMsg, "Invalid Trade - either maturity date is expired or this is lower version, "+ store.getTradeId());
	}
	}

	private Store createTestDate() {
		Store store = new Store();
		store.setTradeId("T2");
		store.setVersion(6);
		store.setCounterPartyId("CP-1");
		store.setBookId("B1");
		store.setMaturityDate(LocalDate.now());
		//store.setCreatedDate(LocalDate.now().minusMonths(3));
		store.setExpiredFlag(false);
		return store;
	}
}

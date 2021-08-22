package com.app.tradestoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.tradestoremanagement.model.Store;
import com.app.tradestoremanagement.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;

	@PostMapping("/store-trade")
	public ResponseEntity<String> storeTrade(@RequestBody Store store) {
		if (storeService.verifyMaturityDate(store) && storeService.isVersionValid(store)) {
			storeService.saveTradeToStore(store);
		} else {
			throw new RuntimeException(
					"Invalid Trade - either maturity date is expired or this is lower version" + store.getTradeId());
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/getAllTrades")
	public List<Store> retrieveAlltrades(){
		return storeService.retrieveTrades();
	}
}

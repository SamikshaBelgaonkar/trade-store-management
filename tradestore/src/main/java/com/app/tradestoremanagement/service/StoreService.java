package com.app.tradestoremanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tradestoremanagement.dao.StoreRepository;
import com.app.tradestoremanagement.model.Store;

@Service
public class StoreService {

	@Autowired
	StoreRepository storeRepository;

	/**
	 * Below method checks if version of trade is valid
	 * 
	 * @param store
	 * @return
	 */
	public boolean isVersionValid(Store store) {
		Optional<Store> trade = storeRepository.findById(store.getTradeId());
		return trade.isPresent() && store.getVersion() >= trade.get().getVersion() ? true : false;
	}

	/**
	 * Store should not allow the trade which has less maturity date then today
	 * date.
	 * 
	 * @param store
	 */
	public boolean verifyMaturityDate(Store store) {
		// TODO Auto-generated method stub
		return store.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}

	/**
	 * stores trade into db
	 * 
	 * @param store
	 */
	public void saveTradeToStore(Store store) {
		storeRepository.save(store);
	}

	/**
	 * this method verifies maturity date and updates expiry date to YES.
	 */
	public void updateFlag() {
		List<Store> existingStoreRecords = storeRepository.findAll();
		for (Store store : existingStoreRecords) {
			if (verifyMaturityDate(store)) {
				store.setExpiredFlag(true);
				storeRepository.save(store);
			}
		}
	}
	
/**
 *Below method returns all existig trades 
 * @return
 */
	public List<Store> retrieveTrades() {
		return storeRepository.findAll();
	}
}

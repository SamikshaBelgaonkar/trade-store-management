package com.app.tradestoremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tradestoremanagement.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, String>{

}

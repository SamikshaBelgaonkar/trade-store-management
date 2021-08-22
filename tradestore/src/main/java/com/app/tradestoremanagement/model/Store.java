package com.app.tradestoremanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trades")
public class Store {
	@Id
	private String tradeId;
	@Column(name = "Version",nullable =false)
	private int version;
	@Column(name = "Counter_PartId",nullable =false)
	private String counterPartyId;
	@Column(name = "Book_Id",nullable =false)
	private String bookId;
	@Column(name = "Maturity_Date",nullable =false)
	private LocalDate maturityDate;
	@Column(name = "Created_Date",nullable =false)
	private LocalDate createdDate;
	@Column(name = "Expired_Flag",nullable =false)
	private boolean expiredFlag;
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isExpiredFlag() {
		return expiredFlag;
	}
	public void setExpiredFlag(boolean expiredFlag) {
		this.expiredFlag = expiredFlag;
	}
	
	
}

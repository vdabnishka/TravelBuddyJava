package com.tek.travelbuddy.entities;

import java.math.BigDecimal;
import java.util.Date;

import android.graphics.Bitmap;

public class Bill implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _billId;
	private int _tripId;
	private BigDecimal _amount;
	private Date _billDate;
	private String _comments;
	private int _billTypeId;
	private int _currencyId;
	private Bitmap _image;
	
	private BillType _billType;
	private Currency _currency;
	
	public Bill(int tripId, String amount, Date billDate, int billTypeId, int currencyId) {
		this(tripId, new BigDecimal(amount), billDate, billTypeId, currencyId);
	}
	
	public Bill(int tripId, BigDecimal amount, Date billDate, int billTypeId, int currencyId) {
		this(0, tripId, amount, billDate, billTypeId, currencyId);
	}
	
	public Bill(int billId, int tripId, String amount, Date billDate, int billTypeId, int currencyId) {
		this(billId, tripId, new BigDecimal(amount), billDate, billTypeId, currencyId);
	}
	
	public Bill(int billId, int tripId, BigDecimal amount, Date billDate, int billTypeId, int currencyId) {
		_billId = billId;
		_tripId = tripId;
		_amount = amount;
		_billDate = billDate;
		_billTypeId = billTypeId;
		_currencyId = currencyId;
	}

	public int getBillId() {
		return _billId;
	}

	public void setBillId(int billId) {
		_billId = billId;
	}

	public BigDecimal getAmount() {
		return _amount;
	}

	public void setAmount(BigDecimal amount) {
		_amount = amount;
	}

	public Date getBillDate() {
		return _billDate;
	}

	public void setBillDate(Date billDate) {
		_billDate = billDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public int getBillTypeId() {
		return _billTypeId;
	}

	public void setBillTypeId(int billTypeId) {
		_billTypeId = billTypeId;
	}

	public int getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(int currencyId) {
		_currencyId = currencyId;
	}

	public Bitmap getImage() {
		return _image;
	}

	public void setImage(Bitmap image) {
		_image = image;
	}

	public BillType getBillType() {
		return _billType;
	}

	public void setBillType(BillType billType) {
		_billType = billType;
	}

	public Currency getCurrency() {
		return _currency;
	}

	public void setCurrency(Currency currency) {
		_currency = currency;
	}

	public int getTripId() {
		return _tripId;
	}

	public void setTripId(int tripId) {
		_tripId = tripId;
	}

	public int getId() {

		return getBillId();
	}
	
	public void setId(int value) {
		setBillId(value);
	}

	public Integer getParentId() {
		return getTripId();
	}
}

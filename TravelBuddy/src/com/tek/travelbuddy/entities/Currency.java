package com.tek.travelbuddy.entities;

public class Currency implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _currencyId;
	private String _code;
	private String _name;
	
	public Currency(int currencyId, String code) {
		this(currencyId, code, "");
	}

	public Currency( String code, String name) {
		this(0, code, name);
	}

	public Currency(int currencyId, String code, String name) {
		_currencyId = currencyId;
		_code = code;
		_name = name;
	}

	public int getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(int currencyId) {
		_currencyId = currencyId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getId() {
		return getCurrencyId();
	}

	public void setId(int value) {
		setCurrencyId(value);
	}
	
	public Integer getParentId() {
		return null;
	}
}

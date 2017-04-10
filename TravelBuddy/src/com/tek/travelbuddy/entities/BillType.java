package com.tek.travelbuddy.entities;

public class BillType implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _billTypeId;
	private String _name;
	private String _description;
	
	public BillType( String name, String description) {
		this(0, name, description);
	}

	public BillType(int billTypeId, String name, String description) {
		_billTypeId = billTypeId;
		_name = name;
		_description = description;
	}

	public int getBillTypeId() {
		return _billTypeId;
	}

	public void setBillTypeId(int billTypeId) {
		_billTypeId = billTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getId() {
		return getBillTypeId();
	}

	public void setId(int value) {
		setBillTypeId(value);
	}
	
	public Integer getParentId() {
		return null;
	}
}

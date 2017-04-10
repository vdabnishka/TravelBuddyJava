package com.tek.travelbuddy.entities;

public class Setting implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _settingId;
	private String _name;
	private String _value;
	
	public Setting(String name, String value) {
		this(0, name, value);
	}

	public Setting(int currencyId, String name, String value) {
		_settingId = currencyId;
		_value = value;
		_name = name;
	}

	public int getSettingId() {
		return _settingId;
	}

	public void setSettingId(int settingId) {
		_settingId = settingId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public int getId() {
		return getSettingId();
	}

	public void setId(int value) {
		setSettingId(value);
	}
	
	public Integer getParentId() {
		return null;
	}

}

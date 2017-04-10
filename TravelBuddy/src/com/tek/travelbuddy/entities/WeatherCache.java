package com.tek.travelbuddy.entities;

import java.util.Date;

public class WeatherCache implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _weatherId;
	private String _city;
	private String _province;
	private String _country;
	private Date _updateTime;
	private String _weatherXml;
	
	public WeatherCache(String city, String province, String country, Date updateTime, String weatherXml) {
		this(0, city, province, country, updateTime, weatherXml);
	}
	
	public WeatherCache(int weatehrId, String city, String province, String country, Date updateTime, String weatherXml) {
		_weatherId = weatehrId;
		_city = city;
		_province = province;
		_country = country;
		_updateTime = updateTime;
		_weatherXml = weatherXml;
	}

	public int getWeatherId() {
		return _weatherId;
	}

	public void setWeatherId(int weatherId) {
		_weatherId = weatherId;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getProvince() {
		return _province;
	}

	public void setProvince(String province) {
		_province = province;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public Date getUpdateTime() {
		return _updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		_updateTime = updateTime;
	}

	public String getWeatherXml() {
		return _weatherXml;
	}

	public void setWeatherXml(String weatherXml) {
		_weatherXml = weatherXml;
	}

	public int getId() {
		return getWeatherId();
	}
	
	public void setId(int value) {
		setWeatherId(value);
	}

	public Integer getParentId() {
		return null;
	}
}

package com.tek.travelbuddy.entities;

import java.util.Date;

public class Trip implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _tripId;
	private String _name;
	private String _description;
	private String _city;
	private String _province;
	private String _country;
	
	private Date _startDate;
	private Date _endDate;
	
	public Trip (String name, String description) {
		this(0, name, description);
	}
	
	public Trip (int tripId, String name, String description) {
		_tripId = tripId;
		_name = name;
		_description = description;
	}

	public int getTripId() {
		return _tripId;
	}
	public void setTripId(int tripId) {
		_tripId = tripId;
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
	public Date getStartDate() {
		return _startDate;
	}
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}
	public Date getEndDate() {
		return _endDate;
	}
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getId() {
		return getTripId();
	}

	public void setId(int value) {
		setTripId(value);
	}
	
	public Integer getParentId() {
		return null;
	}
}

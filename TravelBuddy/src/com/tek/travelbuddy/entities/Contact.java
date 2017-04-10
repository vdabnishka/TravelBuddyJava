package com.tek.travelbuddy.entities;

public class Contact implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _contactId;
	private int _tripId;
	private String _firstName;
	private String _lastName;
	private String _phone;
	private String _email;
	private String _company;
	
	public Contact(int tripId, String firstName, String lastName) {
		this(0, tripId, firstName, lastName);
	}
	
	public Contact(int contactId, int tripId, String firstName, String lastName) {
		_contactId = contactId;
		_tripId = tripId;
		_firstName = firstName;
		_lastName = lastName;
	}

	public int getContactId() {
		return _contactId;
	}
	public void setContactId(int contactId) {

		_contactId = contactId;
	}
	public int getTripId() {
		return _tripId;
	}
	public void setTripId(int tripId) {
		_tripId = tripId;
	}
	public String getFirstName() {
		return _firstName;
	}
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}
	public String getLastName() {
		return _lastName;
	}
	public void setLastName(String lastName) {
		_lastName = lastName;
	}
	public String getPhone() {
		return _phone;
	}
	public void setPhone(String phone) {
		_phone = phone;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		_email = email;
	}
	public String getCompany() {
		return _company;
	}
	public void setCompany(String company) {
		_company = company;
	}

	public int getId() {
		return getContactId();
	}

	public void setId(int value) {
		setContactId(value);
	}
	
	public Integer getParentId() {
		return getTripId();
	}
}

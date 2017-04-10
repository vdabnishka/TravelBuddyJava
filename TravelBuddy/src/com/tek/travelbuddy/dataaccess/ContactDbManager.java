package com.tek.travelbuddy.dataaccess;

import com.tek.travelbuddy.entities.Contact;

import android.content.ContentValues;
import android.database.Cursor;

public class ContactDbManager extends EntityDbManager<Contact> {
	private static String KEY_FNAME = "firstName";
	private static String KEY_LNAME = "lastName";
	private static String KEY_COMPANY = "company";
	private static String KEY_PHONE = "phone";
	private static String KEY_EMAIL = "email";

	private static String TABLE_NAME = "Contacts";
	
	ContactDbManager(EntityDbManager<?> parentMgr) {
		super(parentMgr, TABLE_NAME);
	}
	
	public ContactDbManager() {
		super(TABLE_NAME);
	}

	@Override
	protected Contact getEntity(Cursor c) {
		Contact entity = new Contact(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getInt(c.getColumnIndex(_parentIdColumn)),
				c.getString(c.getColumnIndex(KEY_FNAME)),
				c.getString(c.getColumnIndex(KEY_LNAME)));
		
		entity.setCompany(c.getString(c.getColumnIndex(KEY_COMPANY)));
		entity.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
		entity.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));

		return entity;
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, _parentIdColumn, KEY_FNAME, KEY_LNAME, KEY_COMPANY, KEY_PHONE, KEY_EMAIL};
	}

	@Override
	protected ContentValues getColumnValues(Contact entity) {
		ContentValues values = new ContentValues();
		
		int id = entity.getId();
		if (id != 0) {
			values.put(_rowIdColumn, id);
		}
		
		values.put(_parentIdColumn, entity.getParentId());
		
		values.put(KEY_FNAME, entity.getFirstName());
		values.put(KEY_LNAME, entity.getLastName());
		values.put(KEY_COMPANY, entity.getCompany());
		values.put(KEY_PHONE, entity.getPhone());
		values.put(KEY_EMAIL, entity.getEmail());
		
		return values;
	}

}

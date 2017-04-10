package com.tek.travelbuddy.dataaccess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;
import com.tek.travelbuddy.entities.Trip;

public class TripDbManager extends EntityDbManager<Trip> {
	private static String KEY_NAME = "name";
	private static String KEY_DESC = "description";
	private static String KEY_CITY = "city";
	private static String KEY_PROVINCE = "province";
	private static String KEY_COUNTRY = "country";
	private static String KEY_SDATE = "startDate";
	private static String KEY_EDATE = "endDate";
	private static String DATE_FORMAT = "yyyy-MM-dd";

	private static String TABLE_NAME = "Trips";

	public TripDbManager() {
		super(TABLE_NAME);
	}
	
	public boolean delete(int id) {
		boolean success = false;
		
		_db.beginTransaction();
		
		try {
			BillDbManager bills = new BillDbManager(this);
			ContactDbManager contacts = new ContactDbManager(this);
			NoteDbManager notes = new NoteDbManager(this);
			
			bills.deleteWithParent(id);
			contacts.deleteWithParent(id);
			notes.deleteWithParent(id);
			
			super.delete(id);
			
			success = true;
			_db.setTransactionSuccessful();
		}
		finally {
			_db.endTransaction();
		}

		return success;
	}

	@Override
	protected Trip getEntity(Cursor c) {
		Trip entity = new Trip(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getString(c.getColumnIndex(KEY_NAME)),
				c.getString(c.getColumnIndex(KEY_DESC))
				);
		
		entity.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
		entity.setProvince(c.getString(c.getColumnIndex(KEY_PROVINCE)));
		entity.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Date startDate, endDate;
		
		try {
			startDate = format.parse(c.getString(c.getColumnIndex(KEY_SDATE)));
			endDate = format.parse(c.getString(c.getColumnIndex(KEY_EDATE)));
		}
		catch (ParseException e) {
			startDate = null;
			endDate = null;
		}
		
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		
		return entity;
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, KEY_NAME, KEY_DESC, KEY_CITY, KEY_PROVINCE, KEY_COUNTRY, KEY_SDATE, KEY_EDATE};
	}

	@Override
	protected ContentValues getColumnValues(Trip entity) {
		ContentValues values = new ContentValues();
		
		int id = entity.getId();
		
		if (id != 0) {
			values.put(_rowIdColumn, id);
		}
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		
		values.put(KEY_NAME, entity.getName());
		values.put(KEY_DESC, entity.getDescription());
		values.put(KEY_CITY, entity.getCity());
		values.put(KEY_PROVINCE, entity.getProvince());
		values.put(KEY_COUNTRY, entity.getCountry());
		values.put(KEY_SDATE, format.format(entity.getStartDate()));
		values.put(KEY_EDATE, format.format(entity.getEndDate()));
		
		return values;
	}

}

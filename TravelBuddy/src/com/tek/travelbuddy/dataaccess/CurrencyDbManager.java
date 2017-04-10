package com.tek.travelbuddy.dataaccess;

import android.content.ContentValues;
import android.database.Cursor;

import com.tek.travelbuddy.entities.Currency;

public class CurrencyDbManager extends EntityDbManager<Currency> {
	private static String KEY_CODE = "code";
	private static String KEY_NAME = "name";
	
	private static String TABLE_NAME = "Currencies"; 

	public CurrencyDbManager() {
		super(TABLE_NAME);
	}
	
	public boolean delete(int id) {
		return false;
	}

	@Override
	protected Currency getEntity(Cursor c) {
		return new Currency(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getString(c.getColumnIndex(KEY_CODE)),
				c.getString(c.getColumnIndex(KEY_NAME)));
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, KEY_CODE, KEY_NAME};
	}

	@Override
	protected ContentValues getColumnValues(Currency entity) {
		return null;
	}

}

package com.tek.travelbuddy.dataaccess;

import android.content.ContentValues;
import android.database.Cursor;

import com.tek.travelbuddy.entities.Setting;

public class SettingDbManager extends EntityDbManager<Setting> {
	private static String KEY_NAME = "name";
	private static String KEY_VALUE = "value";

	private static String TABLE_NAME = "Settings";
	
	public SettingDbManager() {
		super(TABLE_NAME);
	}
	
	public boolean delete(int id) {
		return false;
	}

	@Override
	protected Setting getEntity(Cursor c) {
		return new Setting(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getString(c.getColumnIndex(KEY_NAME)),
				c.getString(c.getColumnIndex(KEY_VALUE)));
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, KEY_NAME, KEY_VALUE};
	}

	@Override
	protected ContentValues getColumnValues(Setting entity) {
		ContentValues values = null;
		int id = entity.getId();
		
		if (id != 0) {
			values = new ContentValues();
			
			values.put(_parentIdColumn, id);
			values.put(KEY_VALUE, entity.getValue());
		}
			
		return values;
	}
}

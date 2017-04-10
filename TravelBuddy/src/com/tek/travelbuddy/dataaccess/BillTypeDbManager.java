package com.tek.travelbuddy.dataaccess;

import android.content.ContentValues;
import android.database.Cursor;

import com.tek.travelbuddy.entities.BillType;

public class BillTypeDbManager extends EntityDbManager<BillType> {
	private static String KEY_NAME = "name";
	private static String KEY_DESC = "description";
	
	private static String TABLE_NAME = "BillTypes";

	public BillTypeDbManager() {
		super(TABLE_NAME);
	}

	@Override
	protected BillType getEntity(Cursor c) {
		return new BillType(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getString(c.getColumnIndex(KEY_NAME)),
				c.getString(c.getColumnIndex(KEY_DESC)));
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, KEY_NAME, KEY_DESC};
	}

	@Override
	protected ContentValues getColumnValues(BillType entity) {

		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}
}

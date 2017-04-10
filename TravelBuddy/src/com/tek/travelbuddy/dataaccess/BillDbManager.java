package com.tek.travelbuddy.dataaccess;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;

import com.tek.travelbuddy.common.PhotoUtility;
import com.tek.travelbuddy.entities.Bill;

public class BillDbManager extends EntityDbManager<Bill> {
	
	private static String KEY_AMOUNT = "amount";
	private static String KEY_BILLDATE = "billDate";
	private static String KEY_COMMENTS = "comments";
	private static String KEY_BILLTYPE = "billTypeId";
	private static String KEY_CURRENCY = "currencyId";
	private static String KEY_IMAGE = "image";
	private static String DATE_FORMAT = "yyyy-MM-dd";
	
	private static String TABLE_NAME = "Bills";
	
	BillDbManager(EntityDbManager<?> parentMgr) {

		super(parentMgr, TABLE_NAME);
	}
	
	public BillDbManager() {
		super(TABLE_NAME);
	}

	@Override
	protected Bill getEntity(Cursor c) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Date date;
		try {
			date = format.parse(c.getString(c.getColumnIndex(KEY_BILLDATE)));
		}
		catch (ParseException e) {
			date = null;
		}
		
		Bill bill = new Bill(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getInt(c.getColumnIndex(_parentIdColumn)),
				new BigDecimal(c.getString(c.getColumnIndex(KEY_AMOUNT))),
				date,
				c.getInt(c.getColumnIndex(KEY_BILLTYPE)),
				c.getInt(c.getColumnIndex(KEY_CURRENCY))
				);
		
		bill.setComments(c.getString(c.getColumnIndex(KEY_COMMENTS)));
		
		byte [] imageData = c.getBlob(c.getColumnIndex(KEY_IMAGE));
		bill.setImage(PhotoUtility.loadImage(imageData));

		return bill;
	}

	@Override
	protected String[] getAllColumnNames() {

		return new String[] {_rowIdColumn, _parentIdColumn, KEY_AMOUNT, KEY_BILLDATE, KEY_COMMENTS, KEY_BILLTYPE, KEY_CURRENCY, KEY_IMAGE};
	}

	@Override
	protected ContentValues getColumnValues(Bill entity) {
		ContentValues values = new ContentValues();
		
		int id = entity.getId();
		
		if (id != 0) {
			values.put(_rowIdColumn, id);
		}
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		
		values.put(_parentIdColumn, entity.getParentId());
		values.put(KEY_AMOUNT, entity.getAmount().toString());
		values.put(KEY_BILLDATE, format.format(entity.getBillDate()));
		values.put(KEY_BILLTYPE, entity.getBillTypeId());
		values.put(KEY_CURRENCY, entity.getCurrencyId());
		values.put(KEY_IMAGE, PhotoUtility.getImageData(entity.getImage()));
		
		return values;
	}

}

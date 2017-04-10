package com.tek.travelbuddy.dataaccess;

import android.content.ContentValues;
import android.database.Cursor;

import com.tek.travelbuddy.common.PhotoUtility;
import com.tek.travelbuddy.entities.Note;

public class NoteDbManager extends EntityDbManager<Note> {
	private static String KEY_TITLE = "";
	private static String KEY_CONTENT = "";
	private static String KEY_IMAGE = "";
	
	private static String TABLE_NAME = "Notes";
	
	NoteDbManager(EntityDbManager<?> parentMgr) {
		super(parentMgr, TABLE_NAME);
	}

	public NoteDbManager() {
		super(TABLE_NAME);
	}

	@Override
	protected Note getEntity(Cursor c) {
		Note entity = new Note(
				c.getInt(c.getColumnIndex(_rowIdColumn)),
				c.getInt(c.getColumnIndex(_parentIdColumn)),
				c.getString(c.getColumnIndex(KEY_TITLE)),
				c.getString(c.getColumnIndex(KEY_CONTENT)));
		
		byte [] imageData = c.getBlob(c.getColumnIndex(KEY_IMAGE));
		entity.setImage(PhotoUtility.loadImage(imageData));
		
		return entity;
	}

	@Override
	protected String[] getAllColumnNames() {
		return new String [] {_rowIdColumn, _parentIdColumn, KEY_TITLE, KEY_CONTENT, KEY_IMAGE};
	}

	@Override
	protected ContentValues getColumnValues(Note entity) {
		ContentValues values = new ContentValues();
		
		int id = entity.getId();
		
		if (id != 0) {
			values.put(_rowIdColumn, id);
		}
		
		values.put(_parentIdColumn, entity.getParentId());
		values.put(KEY_TITLE, entity.getTitle());
		values.put(KEY_CONTENT, entity.getContent());
		values.put(KEY_IMAGE, PhotoUtility.getImageData(entity.getImage()));
		
		return values;
	}

}

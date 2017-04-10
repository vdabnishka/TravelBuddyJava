package com.tek.travelbuddy.dataaccess;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.tek.travelbuddy.entities.IEntity;

public abstract class EntityDbManager<TEntity extends IEntity> implements IEntityDbManager<TEntity> {
	
	protected final String _tableName;
	protected final String _rowIdColumn = "_id";
	protected final String _parentIdColumn = "tripId";
	
	protected DbContext _ctx;
	protected SQLiteDatabase _db;
	
 	EntityDbManager(EntityDbManager<?> parentMgr, String tableName) {
		_tableName = tableName;
		_ctx = null;
		_db = parentMgr._db;
	}
 	
 	EntityDbManager(String tableName) {
 		_ctx = new DbContext();
 		_tableName = tableName;
 	}
	
	public List<TEntity> getAll() {
		openDatabase(false);
			
        Cursor c = _db.query(_tableName, getAllColumnNames(), null, null, null, null, null);
        
        List<TEntity> entities = getList(c);
        
        c.close();

        closeDatabase();
        
        return entities;
	}

	public List<TEntity> getAll(int parentId) {
		openDatabase(false);
		
        Cursor c = _db.query(_tableName, getAllColumnNames(), _parentIdColumn + "=?", new String [] {Integer.toString(parentId)}, null, null, null);
        
        List<TEntity> entities = getList(c);
        
        c.close();
        closeDatabase();
        
        return entities;
	}

	public TEntity get(int id) {
		openDatabase(false);
		
        Cursor c = _db.query(_tableName, getAllColumnNames(), _rowIdColumn + "=?", new String [] {Integer.toString(id)}, null, null, null);
        
        List<TEntity> entities = getList(c);
        
        c.close();
        closeDatabase();
        
        TEntity entity = null;

        if (entities.size() > 0) {
        	entity = entities.get(0);
        }
        
        return entity;
	}

	public TEntity save(TEntity entity) {

		ContentValues values = getColumnValues(entity);

		if (values != null && values.size() > 0) {
			openDatabase(true);

			int id = entity.getId();
			if (id != 0) {
				_db.update(_tableName, values, _rowIdColumn + "=?",
						new String[] { Integer.toString(id) });
			} else {
				id = (int) _db.insert(_tableName, null, values);
				entity.setId(id);
			}
			
			closeDatabase();
		}
		return entity;
	}

	public TEntity delete(TEntity entity) {

		if (delete(entity.getId())) {
			entity.setId(0);
		}
		
		return entity;
	}
	
	public boolean delete(int id) {
		openDatabase(true);
		boolean result = _db.delete(_tableName, _rowIdColumn + "=?", new String [] {Integer.toString(id)}) > 0;
		closeDatabase();
		
		return result;
	}
	
	public void deleteWithParent(int parentId) {
		openDatabase(true);
		_db.delete(_tableName, _parentIdColumn + "=?", new String [] {Integer.toString(parentId)});
		closeDatabase();
	}
	
	public void close() {

		closeDatabase();
		
		if (_ctx != null) {
			_ctx.close();
			_ctx = null;
		}
	}

	protected List<TEntity> getList(Cursor c) {
    	ArrayList<TEntity> entities = new ArrayList<TEntity>();
    	
        while (c.moveToNext()) {
        	TEntity entity = this.getEntity(c);
        	
        	entities.add(entity);
        }
        
        return entities;
	}

	protected abstract TEntity getEntity(Cursor c);
	protected abstract String[] getAllColumnNames();
	protected abstract ContentValues getColumnValues(TEntity entity);
	
	protected void openDatabase(boolean allowWrite) {
		if (_ctx != null) {
			if (allowWrite) {
				_db = _ctx.getWritableDatabase();
			}
			else {
				_db = _ctx.getReadableDatabase();
			}
		}
	}
	
	protected void closeDatabase() {
		if (_ctx != null && _db != null && _db.isOpen()) {
			_db.close();
		}

		_db = null;
	}
}

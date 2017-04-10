package com.tek.travelbuddy.dataaccess;

import java.util.List;

import com.tek.travelbuddy.entities.IEntity;

public interface IEntityDbManager<TEntity extends IEntity> {
	List<TEntity> getAll();
	List<TEntity> getAll(int parentId);
	
	TEntity get(int id);
	
	TEntity save(TEntity entity);
	TEntity delete(TEntity entity);
	boolean delete(int id);
	void deleteWithParent(int parentId);
	
	void close();
}

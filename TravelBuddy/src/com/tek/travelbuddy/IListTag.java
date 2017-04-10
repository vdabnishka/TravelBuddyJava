package com.tek.travelbuddy;

import android.view.View;

import com.tek.travelbuddy.entities.IEntity;

public interface IListTag<TEntity extends IEntity> {
	void fill(View view, TEntity item);
}

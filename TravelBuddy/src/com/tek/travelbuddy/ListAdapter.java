package com.tek.travelbuddy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.tek.travelbuddy.dataaccess.EntityDbManager;
import com.tek.travelbuddy.entities.IEntity;

public abstract class ListAdapter<TEntity extends IEntity> extends android.widget.ArrayAdapter<TEntity> {

	protected EntityDbManager<TEntity> _mgr;
	protected List<TEntity> _items;
	
	protected Activity _activityContext;
	protected int _resourceLayoutId;
	
	protected ListAdapter(Context context, int resourceId, EntityDbManager<TEntity> mgr) {
		super(context, resourceId);
		
		_mgr = mgr;
		_items = _mgr.getAll();
		_activityContext = (Activity) context;
		_resourceLayoutId = resourceId;
		
		this.addAll(_items);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;

		if (convertView != null) {
			view = convertView;
		}
		else {
			LayoutInflater inflater = _activityContext.getLayoutInflater();
			view = inflater.inflate(_resourceLayoutId, parent, false);
		}

		IListTag<TEntity> tag = getListTag(view);
		
		TEntity item = getItem(position);
		tag.fill(view, item);

		view.setTag(tag);
		
		return view;
	}

	protected abstract IListTag<TEntity> createListTag(View view);

	@SuppressWarnings("unchecked")
	protected IListTag<TEntity> getListTag(View view) {
		Object objTag = view.getTag();
		
		IListTag<TEntity> tag = (objTag != null)
				? (IListTag<TEntity>) objTag
				: createListTag(view);
		
		return tag;
	}
}

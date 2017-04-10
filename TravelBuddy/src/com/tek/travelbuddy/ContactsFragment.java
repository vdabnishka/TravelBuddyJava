package com.tek.travelbuddy;

import com.tek.travelbuddy.dataaccess.ContactDbManager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactsFragment extends ListFragment {

	private Context _ctx;
	private ContactDbManager _mgr;
	private ContactListAdapter _adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		_ctx = getActivity();
	}
	
	@Override
	public void onResume() {
		super.onResume();

		_mgr = new ContactDbManager();
		_adapter = new ContactListAdapter(_ctx, R.layout.contact_list_layout, _mgr);
		setListAdapter(_adapter);
	}
	
	@Override
	public void onPause() {

		super.onPause();

		_mgr.close();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = inflater.inflate(R.layout.contact_list_layout, container, false);
		return view;
	}
}

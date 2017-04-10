package com.tek.travelbuddy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.tek.travelbuddy.common.Constants;
import com.tek.travelbuddy.dataaccess.TripDbManager;
import com.tek.travelbuddy.entities.Trip;

public class TravelBuddyActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	private TripDbManager _mgr;
	private TripListAdapter _adapter;
	
	private static final int MENU_ADDTRIP = Menu.FIRST;
	private static final int MENU_SETTINGS = Menu.FIRST + 1;
	
	private static final int ACTIVITY_CREATE = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	_mgr = new TripDbManager();
    	_adapter = new TripListAdapter(this, R.layout.trip_item_layout, _mgr);
    	setListAdapter(_adapter);
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	_mgr.close();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	
    	menu.add(0, MENU_ADDTRIP, 0, R.string.menu_addtrip);
    	menu.add(0, MENU_SETTINGS, 0, R.string.menu_settings);
    	
    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	super.onOptionsItemSelected(item);
    	
    	switch (item.getItemId()) {
		case MENU_ADDTRIP:
			Intent intent = new Intent(this, TripEditActivity.class);
			startActivityForResult(intent, ACTIVITY_CREATE);
			
			break;

		case MENU_SETTINGS:
			break;
		}
    	
    	return true;
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	
    	Trip trip = _adapter.getItem(position);
    	
    	Intent intent = new Intent(this, TripDetailsActivity.class);
    	intent.putExtra(Constants.ACTIVITY_PARAM_TRIP, trip);
    	
    	startActivity(intent);
    }
}
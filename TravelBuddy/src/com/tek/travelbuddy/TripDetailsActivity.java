package com.tek.travelbuddy;

import java.util.HashMap;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.tek.travelbuddy.common.Constants;
import com.tek.travelbuddy.entities.Trip;
/*import com.viewpagerindicator.TitlePageIndicator;
*/
public class TripDetailsActivity extends FragmentActivity implements OnPageChangeListener {
	private ViewPager _viewPager;
	private ViewPagerAdapter _adapter;
/*	private TitlePageIndicator _titles;
*/	
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trip_details_layout);
		
		Intent myIntent = getIntent();
		Trip trip = (Trip) myIntent.getExtras().getSerializable(Constants.ACTIVITY_PARAM_TRIP);
		setTitle(trip.getName());

		initializeViews(savedInstanceState);
	}
	
	private void initializeViews(Bundle args) {
		HashMap<String, Fragment> fragments = new HashMap<String, Fragment>();
		Resources res = getResources();
		
		fragments.put(res.getString(R.string.tab_name_trip), Fragment.instantiate(this, TripInfoFragment.class.getName(), args));
		fragments.put(res.getString(R.string.tab_name_contacts), Fragment.instantiate(this, ContactsFragment.class.getName(), args));
		
		_adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);

		_viewPager = (ViewPager) findViewById(R.id.viewPager);
		_viewPager.setAdapter(_adapter);
		_viewPager.setOnPageChangeListener(this);
		
/*		_titles = (TitlePageIndicator) findViewById(R.id.titles);
		_titles.setViewPager(_viewPager);
		_titles.setOnPageChangeListener(this);
*/	}

	public void onPageScrollStateChanged(int state) {
	}

	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	public void onPageSelected(int position) {
		// TODO Add Context Menu
	}
	
}

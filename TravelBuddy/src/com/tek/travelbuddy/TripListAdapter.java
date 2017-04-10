package com.tek.travelbuddy;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tek.travelbuddy.common.DateUtility;
import com.tek.travelbuddy.dataaccess.TripDbManager;
import com.tek.travelbuddy.entities.Trip;

public class TripListAdapter extends ListAdapter<Trip> {

	public TripListAdapter(Context context, int resourceLayoutId, TripDbManager mgr) {
		super(context, resourceLayoutId, mgr);
	}

	@Override
	protected IListTag<Trip> createListTag(View view) {
		return new TripListTag();
	}
	
	private static class TripListTag implements IListTag<Trip> {
		private TextView _name;
		private TextView _city;
		private TextView _country;
		private TextView _startDate;
		private TextView _endDate;
		
		public void fill(View view, Trip trip) {
			getDisplayFields(view);
			
			_name.setText(trip.getName());
			_city.setText(trip.getCity());
			_country.setText(trip.getCountry());
			_startDate.setText(DateUtility.getDateText(trip.getStartDate()));
			_endDate.setText(DateUtility.getDateText(trip.getEndDate()));
		}
		
		private void getDisplayFields(View view) {
			_name = (TextView) view.findViewById(R.id.trip_list_name);
			_city = (TextView) view.findViewById(R.id.trip_list_city);
			_country = (TextView) view.findViewById(R.id.trip_list_country);
			_startDate = (TextView) view.findViewById(R.id.trip_list_startdate);
			_endDate = (TextView) view.findViewById(R.id.trip_list_enddate);
		}
	}

}

package com.tek.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tek.travelbuddy.common.Constants;
import com.tek.travelbuddy.common.DateUtility;
import com.tek.travelbuddy.entities.Trip;

public class TripInfoFragment extends Fragment {
	private Trip _trip;
	private TextView _name;
	private TextView _city;
	private TextView _state;
	private TextView _country;
	private TextView _startDate;
	private TextView _endDate;
	private TextView _description;
	
	private View _view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		_view = inflater.inflate(R.layout.trip_info_layout, container, false);

		initControls();
		fillTripInfo();
		
		return _view;
	}
	
	private void initControls() {
		_name = findViewById(R.id.trip_info_name);
		_city = findViewById(R.id.trip_info_city);
		_state = findViewById(R.id.trip_info_state);
		_country = findViewById(R.id.trip_info_country);
		_startDate = findViewById(R.id.trip_info_startdate);
		_endDate = findViewById(R.id.trip_info_enddate);
		_description = findViewById(R.id.trip_info_description);
	}

	private void fillTripInfo() {
		Bundle extras = getIntent().getExtras();
		
		if (extras != null)
		{
			_trip = (Trip) extras.getSerializable(Constants.ACTIVITY_PARAM_TRIP);
		}
		
		if (_trip != null)
		{
			_name.setText(_trip.getName());
			_city.setText(_trip.getCity());
			_state.setText(_trip.getProvince());
			_country.setText(_trip.getCountry());
			_startDate.setText(DateUtility.getDateText(_trip.getStartDate()));
			_endDate.setText(DateUtility.getDateText(_trip.getEndDate()));
			_description.setText(_trip.getDescription());
		}
	}
	private Intent getIntent() {
		return getActivity().getIntent();
	}

	private TextView findViewById(int id) {

		return (TextView) _view.findViewById(id);
	}
}

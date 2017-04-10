package com.tek.travelbuddy;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tek.travelbuddy.DatePickerFragment.DatePickListener;
import com.tek.travelbuddy.common.Constants;
import com.tek.travelbuddy.common.DateUtility;
import com.tek.travelbuddy.dataaccess.TripDbManager;
import com.tek.travelbuddy.entities.Trip;

public class TripEditActivity extends Activity implements DatePickListener {
	private boolean _isNewTrip = true;
	private Trip _trip = null;
	
	private EditText _name;
	private EditText _city;
	private EditText _state;
	private EditText _country;
	private EditText _startDate;
	private EditText _endDate;
	private EditText _description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trip_edit_layout);
		
		initControls();
		fillTripInfo();
		
		this.setTitle(_isNewTrip ? R.string.title_new_trip : R.string.title_edit_trip);
	}
	
	private void initControls() {
		_name = (EditText) findViewById(R.id.trip_edit_name);
		_city = (EditText) findViewById(R.id.trip_edit_city);
		_state = (EditText) findViewById(R.id.trip_edit_state);
		_country = (EditText) findViewById(R.id.trip_edit_country);
		_startDate = (EditText) findViewById(R.id.trip_edit_startdate);
		_endDate = (EditText) findViewById(R.id.trip_edit_enddate);
		_description = (EditText) findViewById(R.id.trip_edit_description);
	}
	
	private void fillTripInfo() {
		Bundle extras = getIntent().getExtras();
		
		if (extras != null)
		{
			_trip = (Trip) extras.getSerializable(Constants.ACTIVITY_PARAM_TRIP);
		}
		
		_isNewTrip = _trip == null || _trip.getId() <= 0;
		
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

	public void startDateClicked(View view) {
		showDatePick(_startDate);
	}
	
	public void endDateClicked(View view) {
		showDatePick(_endDate);
	}
	
	public void saveClicked(View view){
		this.save();
		setResult(RESULT_OK);
		finish();
	}
	
	private void showDatePick(TextView target) {
		Date sDate = DateUtility.parseDate(target.getText().toString());
		DatePickerFragment dp = new DatePickerFragment(target, this, sDate);
		dp.show(getFragmentManager(), "DatePicker");
	}
	
	private boolean save() {
		boolean canSave = true;
		if (_isNewTrip) {
			_trip = new Trip(_name.getText().toString(), "");
		}
		
		_trip.setCity(_city.getText().toString());
		_trip.setProvince(_state.getText().toString());
		_trip.setCountry(_country.getText().toString());

		_trip.setStartDate(DateUtility.parseDate(_startDate.getText().toString()));
		_trip.setEndDate(DateUtility.parseDate(_endDate.getText().toString()));
		
		_trip.setDescription(_description.getText().toString());
		
		TripDbManager mgr = new TripDbManager();
		mgr.save(_trip);

		return canSave;
	}
	
	public void OnDatePicked(TextView source, Date selectedDate) {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
		source.setText(format.format(selectedDate));
	}
}

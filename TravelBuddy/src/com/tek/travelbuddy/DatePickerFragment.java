package com.tek.travelbuddy;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerFragment extends DialogFragment implements OnDateSetListener {
	private Date _date;
	private TextView _source;
	private DatePickListener _target;
	
	public DatePickerFragment(TextView source, DatePickListener target) {
		this(source, target, null);
	}
	
	public DatePickerFragment(TextView source, DatePickListener target, Date date) {
		_source = source;
		_target = target;
		
		if (date == null) {
			_date = new Date();
		}
		else {
			_date = date;
		}
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);
		
		Dialog dlg = new DatePickerDialog(getActivity(), this,
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		
		return dlg;
	}
	
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, monthOfYear);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		
		_date = calendar.getTime();
		
		_target.OnDatePicked(_source, _date);
	}
	
	public Date getDate() {
		return _date;
	}

	public static interface DatePickListener {
		void OnDatePicked(TextView source, Date selectedDate);
	}
}

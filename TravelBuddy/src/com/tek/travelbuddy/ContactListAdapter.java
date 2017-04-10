package com.tek.travelbuddy;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tek.travelbuddy.dataaccess.ContactDbManager;
import com.tek.travelbuddy.entities.Contact;

public class ContactListAdapter extends ListAdapter<Contact> {

	protected ContactListAdapter(Context context, int resourceId,
			ContactDbManager mgr) {
		super(context, resourceId, mgr);
	}

	@Override
	protected IListTag<Contact> createListTag(View view) {
		return new ContactListTag();
	}
	
	private static class ContactListTag implements IListTag<Contact> {

		private TextView _firstName;
		private TextView _lastName;
		
		public void fill(View view, Contact item) {
			getDisplayFields(view);
			_firstName.setText(item.getFirstName());
			_lastName.setText(item.getLastName());
		}
		
		private void getDisplayFields(View view) {
			_firstName = (TextView) view.findViewById(R.id.contact_first_name);
			_lastName = (TextView) view.findViewById(R.id.contact_last_name);
		}
		
	}
}

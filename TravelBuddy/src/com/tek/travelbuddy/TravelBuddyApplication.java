package com.tek.travelbuddy;

import android.app.Application;
import android.content.Context;

public class TravelBuddyApplication extends Application {
	private static TravelBuddyApplication _instance;
	@Override
	public void onCreate() {
		super.onCreate();
		_instance = this;
	}
	
	public static Context getAppContext() {
		return _instance;
	}
}

package com.tek.travelbuddy;

import android.app.Fragment;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class TabFactory implements TabContentFactory {

	private Fragment _fragment;
	
	public TabFactory(Fragment fragment) {
		_fragment = fragment;
	}

	public View createTabContent(String tag) {
		return _fragment.getView();
	}

}

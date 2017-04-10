package com.tek.travelbuddy;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	
	private ArrayList<Fragment> _fragments = new ArrayList<Fragment>();
	private ArrayList<String> _titles = new ArrayList<String>();
	
	public ViewPagerAdapter(FragmentManager mgr, HashMap<String, Fragment> fragments)
	{
		super(mgr);
		
		_fragments.addAll(fragments.values());
		_titles.addAll(fragments.keySet());
		
	}

	@Override
	public int getCount() {
		return _fragments.size();
	}

	@Override
	public Fragment getItem(int index) {
		return _fragments.get(index);
	}

	@Override
	public CharSequence getPageTitle(int position) {

		return _titles.get(position);
	}
}

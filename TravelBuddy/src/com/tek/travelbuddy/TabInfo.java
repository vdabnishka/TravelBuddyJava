package com.tek.travelbuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TabHost.TabSpec;

public class TabInfo {
    private String _tag;
    private Class<?> _fragmentClass;
    private Bundle _args;
    private Fragment _fragment;
    private TabSpec _tabSpec;

    TabInfo(String tag, Class<?> fragmentClass, Bundle args, TabSpec tabSpec) {
        _tag = tag;
        _fragmentClass = fragmentClass;
        _args = args;
        _tabSpec = tabSpec;
    }

    public String getTag() {
    	return _tag;
    }
    
    public Bundle getArgs() {
    	return _args;
    }
    
    public Fragment getFragment() {
    	return _fragment;
    }
    
    public void setFragment(Fragment fragment) {
    	_fragment = fragment;
    	_fragmentClass = _fragment.getClass();
    }
    
    public Class<?> getFragmentClass() {
    	return _fragmentClass;
    }
    
    public TabSpec getTabSpec() {
    	return _tabSpec;
    }
}

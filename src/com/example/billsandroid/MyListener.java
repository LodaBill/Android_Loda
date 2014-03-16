package com.example.billsandroid;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class MyListener implements ActionBar.TabListener {
	private Fragment fragment;
	
	public MyListener(Fragment fragment) {
		this.fragment = fragment;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.FragmentContanier, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}

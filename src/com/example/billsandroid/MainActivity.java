package com.example.billsandroid;

import com.example.fragment.ChatFragment;
import com.example.fragment.Fragment1;
import com.example.fragment.Fragment2;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(actionBar.newTab().setText("a").setTabListener(new MyListener(new ChatFragment())));
		actionBar.addTab(actionBar.newTab().setText("b").setTabListener(new MyListener(new Fragment1())));
		actionBar.addTab(actionBar.newTab().setText("v").setTabListener(new MyListener(new Fragment2())));
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

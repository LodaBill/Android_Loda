package com.example.billsandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView)this.findViewById(R.id.listView);
		List<Music> musicList = new ArrayList<Music>();
		for(int i=0;i<100;i++){
			musicList.add(new Music(Integer.toString(i), Integer.toString(i), R.drawable.ic_launcher));
		}
		MyAdapter myAdapter = new MyAdapter(this, R.layout.listview_layout, musicList);
		listView.setAdapter(myAdapter);		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Intent intent = new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

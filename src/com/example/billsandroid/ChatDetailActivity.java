package com.example.billsandroid;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.adapter.ChatAdapter;
import com.example.model.ChatDetail;

public class ChatDetailActivity extends Activity {
	private ArrayList<ChatDetail> arrayList = new ArrayList<ChatDetail>();
	private ChatAdapter chatAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_detail);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle(getIntent().getStringExtra("#CONSTANT#TITLE#"));
		
		findViewById(R.id.SendMessage).setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				EditText editText = (EditText)findViewById(R.id.inputbox);
				arrayList.add(new ChatDetail(editText.getText().toString(), "Robot", new Date(),R.drawable.ic_launcher));
				UpdateAdapter();
			}
		});
		ListView listView = (ListView)findViewById(R.id.MyChatlistView);
		chatAdapter = new ChatAdapter(this, R.layout.chat_list_view_layout, arrayList);
		listView.setAdapter(chatAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat_detail, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){
		switch (menuItem.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;

		default:
			break;
		}
		return true;
	}
	
	
	public void UpdateAdapter(){
		chatAdapter.notifyDataSetChanged();
		((ListView)findViewById(R.id.MyChatlistView)).setSelection(chatAdapter.getCount()-1);
	}

}

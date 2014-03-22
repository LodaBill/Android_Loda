package com.example.billsandroid;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.adapter.ChatAdapter;
import com.example.dataaccess.DateAccess;
import com.example.dataaccess.MyDBHelper;
import com.example.model.ChatDetail;
import com.example.model.ChatEntry;

public class ChatDetailActivity extends Activity {
	private ArrayList<ChatDetail> arrayList ;
	private ChatAdapter chatAdapter;
	private String ChatPersonName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_detail);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ChatPersonName = getIntent().getStringExtra("#CONSTANT#TITLE#");
		getActionBar().setTitle(ChatPersonName);
		
		findViewById(R.id.SendMessage).setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				ChatDetail chatDetail ;
				EditText editText = (EditText)findViewById(R.id.inputbox);
				
				chatDetail = new ChatDetail(editText.getText().toString(), ChatPersonName,"Me", new Date(),R.drawable.ic_launcher);
				arrayList.add(chatDetail);
				DateAccess.UpdateDB(v.getContext(),chatDetail);
				
				chatDetail = new ChatDetail(editText.getText().toString(), "Me",ChatPersonName, new Date(),R.drawable.ic_launcher);
				arrayList.add(chatDetail);
				DateAccess.UpdateDB(v.getContext(),chatDetail);
				
				UpdateAdapter();
			}
		});
		//bind listview from the data in db
		String selection = ChatEntry.COLUMN_NAME_FROM+"=? or "+ChatEntry.COLUMN_NAME_TO +"=?";
		String[] selectionArgs = {ChatPersonName,ChatPersonName};
		if(arrayList == null){
			arrayList = DateAccess.SearchDB(getApplicationContext(),selection,selectionArgs);
		}
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
	
	
	private void UpdateAdapter(){
		chatAdapter.notifyDataSetChanged();
		//scroll to bottom
		((ListView)findViewById(R.id.MyChatlistView)).setSelection(chatAdapter.getCount()-1);
	}

}

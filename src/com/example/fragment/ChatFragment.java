package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MyAdapter;
import com.example.billsandroid.ChatDetailActivity;
import com.example.billsandroid.R;
import com.example.billsandroid.R.drawable;
import com.example.billsandroid.R.id;
import com.example.billsandroid.R.layout;
import com.example.model.Music;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChatFragment extends Fragment{
	
private MyAdapter myAdapter; 
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		//get data from db
		myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.listview_layout, getList(getActivity().getContentResolver()));
		super.onCreate(savedInstanceState);
	}
	
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.chatfragment_layout, container,false);
		
		ListView listView = (ListView)view.findViewById(R.id.listView);
		listView.setAdapter(myAdapter);		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Intent intent = new Intent(getActivity(),ChatDetailActivity.class);
				Music music = (Music)parent.getItemAtPosition(position);
				intent.putExtra("#CONSTANT#TITLE#", music.sTitle);
				startActivity(intent);
			}
		});
		
		return view;
	}
	
	private ArrayList<Music> getList(ContentResolver cr){
		ArrayList<Music> list = new ArrayList<Music>();
		    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
		    if (cur.getCount() > 0) {
			    while (cur.moveToNext()) {
			        String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
			        String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			        list.add(new Music(name, name, R.drawable.ic_launcher));
			    }
		    }
		return list;
	}

}

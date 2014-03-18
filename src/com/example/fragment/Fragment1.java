package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MyAdapter;
import com.example.billsandroid.LoginActivity;
import com.example.billsandroid.R;
import com.example.billsandroid.R.drawable;
import com.example.billsandroid.R.id;
import com.example.billsandroid.R.layout;
import com.example.model.Music;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment1 extends Fragment{
	
private MyAdapter myAdapter; 
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		List<Music> musicList = new ArrayList<Music>();
		for(int i=3;i<100;i++){
			musicList.add(new Music(Integer.toString(i), Integer.toString(i), R.drawable.ic_launcher));
		}
		myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.listview_layout, musicList);
		
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
				Intent intent = new Intent(getActivity(),LoginActivity.class);
				startActivity(intent);
			}
		});
		
		return view;
	}

}

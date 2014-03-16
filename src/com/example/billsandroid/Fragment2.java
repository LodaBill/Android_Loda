package com.example.billsandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment2 extends Fragment{
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.chatfragment_layout, container);
		
		ListView listView = (ListView)getView().findViewById(R.id.listView);
		List<Music> musicList = new ArrayList<Music>();
		for(int i=3;i<100;i++){
			musicList.add(new Music(Integer.toString(i), Integer.toString(i), R.drawable.ic_launcher));
		}
		MyAdapter myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.listview_layout, musicList);
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

package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.billsandroid.R;
import com.example.model.ChatDetail;

public class ChatAdapter extends ArrayAdapter<ChatDetail> {
	private Context context;
	
	public ChatAdapter(Context context, int resourceId, List<ChatDetail> list){
		super(context,resourceId,list);
		this.context = context;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ChatDetail chatDetail = (ChatDetail)getItem(position);
		View view;
		
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		if(chatDetail.sFrom != "Me"){
			 view = layoutInflater.inflate(R.layout.chat_list_view_layout, null);
		}
		else{
			 view = layoutInflater.inflate(R.layout.chat_list_view_layout2, null);
		}
		
		
		TextView contentTextView =((TextView)view.findViewById(R.id.chat_content)); 
		contentTextView.setText(chatDetail.sMessage);
		contentTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		contentTextView.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		((TextView)view.findViewById(R.id.chat_date)).setText(DateFormat.format("hh:mm:ss", chatDetail.dDate));
		((ImageView)view.findViewById(R.id.user_image)).setImageResource(chatDetail.iPic);
		return view;
	}
}

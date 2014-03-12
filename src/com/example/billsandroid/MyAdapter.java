package com.example.billsandroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Music> {
	private Context context;
	public  MyAdapter(Context context,int resourcesId, List<Music> itemList) {
		// TODO Auto-generated constructor stub
		super(context, resourcesId,itemList);
		this.context = context;
	}
	
	@Override
	public View getView(int position,View convertView, ViewGroup parent){
		
		LayoutInflater inflater =  (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.listview_layout,null);
		Music temp = getItem(position);
		TextView title = (TextView)rowView.findViewById(R.id.title);
		TextView content = (TextView)rowView.findViewById(R.id.content);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.list_image);
		title.setText(temp.sTitle);
		content.setText(temp.sContent);
		imageView.setImageResource(temp.iPic);
		return rowView;
	}
}

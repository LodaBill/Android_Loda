package com.example.dataaccess;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.example.billsandroid.R;
import com.example.model.ChatDetail;
import com.example.model.ChatEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;


public class DateAccess{
	public static void UpdateDB(Context context,ChatDetail chatDetail){
		MyDBHelper myDBHelper = new MyDBHelper(context);
		SQLiteDatabase db = myDBHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ChatEntry.COLUMN_NAME_FROM,chatDetail.sFrom);
		values.put(ChatEntry.COLUMN_NAME_TO,chatDetail.sTo);
		values.put(ChatEntry.COLUMN_NAME_TIME,DateFormat.format("hh:mm:ss", chatDetail.dDate).toString());
		values.put(ChatEntry.COLUMN_NAME_CONTENT,chatDetail.sMessage);
		db.insert(ChatEntry.TABLE_NAME, null, values);
	}
	
	public static ArrayList<ChatDetail> SearchDB(Context context , String selection , String[] selectionArgs){
		MyDBHelper myDBHelper = new MyDBHelper(context);
		SQLiteDatabase db= myDBHelper.getReadableDatabase();
		String[] columns =  {
				ChatEntry.COLUMN_NAME_ID,
				ChatEntry.COLUMN_NAME_FROM,
				ChatEntry.COLUMN_NAME_TO,
				ChatEntry.COLUMN_NAME_TIME,
				ChatEntry.COLUMN_NAME_CONTENT
		};
		Cursor cursor = db.query(ChatEntry.TABLE_NAME, columns, selection, selectionArgs, null,null,null);
		ArrayList<ChatDetail> list = new ArrayList<ChatDetail>();
		cursor.moveToFirst();
		while(cursor.moveToNext()){
			ChatDetail temp= new ChatDetail(cursor.getString(
					cursor.getColumnIndex(ChatEntry.COLUMN_NAME_CONTENT)),
					cursor.getString(cursor.getColumnIndex(ChatEntry.COLUMN_NAME_CONTENT)), 
					cursor.getString(cursor.getColumnIndex(ChatEntry.COLUMN_NAME_CONTENT)), 
					new Date(), 
					R.drawable.ic_launcher);
			list.add(temp);
			
		}		
		
		return list;
	}
}

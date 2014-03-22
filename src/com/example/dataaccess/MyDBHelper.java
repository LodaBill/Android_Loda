package com.example.dataaccess;

import com.example.model.ChatEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper  extends SQLiteOpenHelper{
	private static String dB_TableName = "db_chat";
	private static int dB_Version = 1;
	
	private static String CRATESTRING = "create table "+ChatEntry.TABLE_NAME+"("+
					ChatEntry.COLUMN_NAME_ID+" INTEGER PRIMARY KEY,"+
					ChatEntry.COLUMN_NAME_TO +" TEXT,"+
					ChatEntry.COLUMN_NAME_CONTENT +" TEXT,"+
					ChatEntry.COLUMN_NAME_FROM +" TEXT,"+
					ChatEntry.COLUMN_NAME_TIME +" TEXT)";
	private static String UPDATAESTRING = "";
	private static final String DELETESTRING =
		    "DROP TABLE IF EXISTS " + ChatEntry.TABLE_NAME;
	public MyDBHelper(Context context){
		super(context,dB_TableName,null,dB_Version);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL(DELETESTRING);
		onCreate(db);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CRATESTRING);
	}		
}









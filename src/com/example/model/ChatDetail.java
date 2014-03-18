package com.example.model;

import java.util.Date;

public class ChatDetail {
	public String sMessage;
	public String sUserName;
	public Date dDate;
	public int iPic;
	public ChatDetail(String sMessageString, String sUserName, Date dDate,int iPic){
		this.sMessage = sMessageString ;
		this.sUserName = sUserName;
		this.dDate = dDate; 
		this.iPic = iPic;
	}
	
}

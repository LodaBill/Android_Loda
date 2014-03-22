package com.example.model;

import java.util.Date;

public class ChatDetail {
	public String sMessage;
	public String sFrom;
	public String sTo;
	public Date dDate;
	public int iPic;
	public ChatDetail(String sMessageString, String sFrom,String sTo, Date dDate,int iPic){
		this.sMessage = sMessageString ;
		this.sFrom = sFrom;
		this.sTo = sTo;
		this.dDate = dDate; 
		this.iPic = iPic;
	}
	
}

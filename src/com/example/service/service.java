package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class service {
	public void SendMessage(){
		//CloseableHttpClient httpClient = HttpClients
		try{
		HttpPost request = new HttpPost("http://asdfas/s/");
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("", ""));
		
		request.setEntity(new UrlEncodedFormEntity(parameters,""));
		HttpResponse response = new DefaultHttpClient().execute(request);
		}
		catch(Exception e){
			
		}
		
	}
	
	public String GetMessage(){
		return "what the fuck";
	}
}

package com.example.s_crewclientapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import android.os.AsyncTask;
import android.widget.Toast;


public class connect_to_Server extends AsyncTask<Object, Integer, Object>{
	Socket serverside=null;
	InputStream i=null;
	OutputStream o=null;
	
	
	public void connect_it(){
	   
	   
	  
	   try {
		serverside=new Socket("localhost",5544);//serverside ist der server
	     } catch (UnknownHostException e) {
		CharSequence text;
		text = (CharSequence) e;
		Toast toast = Toast.makeText(null, text,Toast.LENGTH_LONG);
				toast.show();
		
		// TODO Auto-generated catch block
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		CharSequence text;
		text = (CharSequence) e;
		Toast toast = Toast.makeText(null,text, Toast.LENGTH_LONG);
				toast.show();
		

	}
	//Ende try catch
	   
	  try {
		i= serverside.getInputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		o= serverside.getOutputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  HashMap<String, Number> anzahl= new HashMap<String,Number>();
	  anzahl.put("Bratwürstchen im Brötchen",3);
	  ObjectOutputStream oos = null;
	try {
		oos = new ObjectOutputStream(o);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		oos.writeObject(anzahl);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 /** try {
		serverside.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  */
//	  dis = new DataInputStream(i);
//	  dis.
	
	
	
	
	 //server.//Essensplan= noch davor schreiben aber vorher Essensplanklasse deklarieren :)	
	 

	
	//finally
}

	

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		connect_it();
		return null;
	}
}
package com.example.s_crewclientapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
public class MainActivity extends Activity {
Socket serverside = null;
		   InputStream i=null;
		   OutputStream o=null;
		   Thread t=null;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
   public void setBestellung(View view){
	   t= new Thread(new Runnable(){
	   public void run(){
//	   new connect_to_Server().connect_it();
	 
   
	   
	   try {
		serverside=new Socket("veteran1.ez.lv",5544);//serverside ist der server
	     } catch (UnknownHostException e) {
	    	 e.printStackTrace();
		
		// TODO Auto-generated catch block
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		

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
	   }
	   });
	   t.start();
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

  



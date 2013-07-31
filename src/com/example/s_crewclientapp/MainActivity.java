package com.example.s_crewclientapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class MainActivity extends Activity {

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
   public void setBestellung() throws IOException{
	  //variable deklaration
	   Socket serverside = null;
	  
	   try {
		serverside=new Socket("localhost",5555);//serverside ist der server
	} catch (UnknownHostException e) {
		CharSequence text;
		text = (CharSequence) e;
		Toast toast = Toast.makeText(getApplicationContext(),text, 10);
				toast.show();
		
		// TODO Auto-generated catch block
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		CharSequence text;
		text = (CharSequence) e;
		Toast toast = Toast.makeText(getApplicationContext(),text, 10);
				toast.show();
		

	}
	//Ende try catch
	   
	   ObjectInputStream obi=(ObjectInputStream) serverside.getInputStream();
	 OutputStream o= serverside.getOutputStream();
	 Object server;
	 try {
		server = obi.readObject();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		CharSequence text;
		text = (CharSequence) e;
		Toast toast = Toast.makeText(getApplicationContext(),text, 10);
				toast.show();
	}
	//Ende Try catch
	
	 
	 server.//Essensplan= noch davor schreiben aber vorher Essensplanklasse deklarieren :)	
	 

	
	//finally
	serverside.close();
	 
	   
   }
}

package com.example.s_crewclientapp;

import com.example.s_crewclientapp.R;
import com.example.s_crewclientapp.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
		   String UserID=null;
		   String UserBestellung=null;
		   
		  
		   
		
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
	  EditText et= (EditText) findViewById(R.id.UsersName);
	  UserID=et.getText().toString();
	  EditText et2=(EditText) findViewById(R.id.bestellungstext);
	  UserBestellung=et2.getText().toString();
	  HashMap<String,String> behelfsmap=new HashMap<String,String>();
	  behelfsmap.put(UserID, UserBestellung);
//	  HashMap<String, HashMap<String, Number>> bestellung=new HashMap<String, HashMap<String, Number>>();
//	  HashMap<String, Number> anzahl= new HashMap<String,Number>();
//	  anzahl.put("Bratwürstchen im Brötchen",3);
//	  bestellung.put(UserID, anzahl);
	  ObjectOutputStream oos = null;
	try {
		oos = new ObjectOutputStream(o);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
//		oos.writeObject(bestellung);
		  oos.writeObject(behelfsmap);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  
	   }
	   });
	   t.start();
   }
	   
	/** try {
	*	serverside.close();
	*} catch (IOException e) {
	*	// TODO Auto-generated catch block
	*	e.printStackTrace();
	*}
	*/
//	  dis = new DataInputStream(i);
//	  dis.
	   
}   

  



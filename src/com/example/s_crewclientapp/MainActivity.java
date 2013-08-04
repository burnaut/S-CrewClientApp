package com.example.s_crewclientapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import java.io.*;
import java.net.Socket;
public class MainActivity extends Activity {
Socket serverside = null;
		   InputStream i=null;
		   OutputStream o=null;
		
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
	
   public void setBestellung(View view){//google: 08-03 16:17:43.513: E/AndroidRuntime(1087): Caused by: android.os.NetworkOnMainThreadException

	   new connect_to_Server().connect_it();
	   }

		
	   
   }

  



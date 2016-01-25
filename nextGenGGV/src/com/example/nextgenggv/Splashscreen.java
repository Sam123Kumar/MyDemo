package com.example.nextgenggv;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class Splashscreen extends Activity {
   
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		new SplashShow().execute();
	  
		
	}
	
	

	
	class SplashShow extends AsyncTask
	{

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			
			
				Intent i=new Intent(getBaseContext(),MainScreen.class);
				startActivity(i);
				finish();
			
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			Thread t=new Thread()
			{
			
				public void run()
				{
					
					int prog=0;
					while(prog<=100)
					{
						prog+=4;
						try {
							sleep(200);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
					}
					
				}
				
			
				
			};
			t.start();
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{}
			return null;
		}
		
		
		
	}

	

}



package com.example.nextgenggv;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
	}
public void dir(View v)
{
  Intent i=new Intent(getApplicationContext(),Dir.class);	
  startActivity(i);
 
}




	public void map(View v)
	{
		Intent i = new Intent(this,MapMoves.class);
		startActivity(i);
		
	}
	
	public void news(View v)
	{
		
	startActivity(new Intent(getApplicationContext(),phpNews.class));	
		
	}
	
	public void admission(View v)
	{
		Intent i = new Intent(this,Admissions.class);
		startActivity(i);
		
		
	}
	
	public void prog(View v)
	{
		
		
		
	}
	
	public void about(View v)
	{
		
		
		
	}
public void student(View v)
{
	
}
}

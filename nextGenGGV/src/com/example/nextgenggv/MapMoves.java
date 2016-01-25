package com.example.nextgenggv;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MapMoves extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_moves);
	}

	public void googlemap(View v)
	{
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
		
	}
	
	public void address(View v)
	{
		Intent i=new Intent(this,Address.class);
		startActivity(i);
		
	}
	
	
	
	

	
	
}

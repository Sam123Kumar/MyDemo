package com.example.nextgenggv;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class News extends Activity {
TextView content,head;
String lolo="",chlo="";	
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
	content=(TextView) findViewById(R.id.content);
	head=(TextView) findViewById(R.id.heading);
	lolo=getIntent().getStringExtra("cont");
	chlo=getIntent().getStringExtra("head");
	content.setText(lolo);
	head.setText(chlo);
	head.setBackgroundColor(Color.CYAN);
	content.setBackgroundColor(Color.LTGRAY);
	
	}

	

}

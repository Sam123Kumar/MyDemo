package com.example.nextgenggv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Admissions extends Activity {

	
	
	    String dest_file_path = "test.pdf";
	    int downloadedSize = 0, totalsize;
	    String download_file_url = "http://www.ggu.ac.in/download/VET14-15/Admission%20Brouchure%202014-15%20New.pdf";
	    float per = 0;
	    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admissions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
   

    public void download(View v)
    {
  //  	 downloadAndOpenPDF();
    	//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ggu.ac.in/download/VET14-15/Admission%20Brouchure%202014-15%20New.pdf")));
    	//downloadPdfContent("https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=0CCwQFjAC&url=http%3A%2F%2Fwww.tutorialspoint.com%2Fandroid%2Fandroid_tutorial.pdf&ei=vnAlVYC5IsefugSWvYGgBA&usg=AFQjCNF9pjrm8zcuuZ0iTF1Nc5X8M7zwWA&sig2=WgFy2-ucv_8vBCmageWFtg&bvm=bv.90237346,d.c2E");
       // new DownloadFile().execute("http://www.ggu.ac.in/download/VET14-15/Admission%20Brouchure%202014-15%20New.pdf", "maven.pdf"); 
    }

    public void addnews(View v)
    {
    	
    	startActivity(new Intent(getApplicationContext(), AddNews.class));
    	
    }
        }



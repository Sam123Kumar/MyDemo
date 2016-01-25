package com.example.nextgenggv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DirName extends Activity
{  private String jsonResult;
String table="";
private String url = "http://192.168.1.16/dir";
private ListView l;
String name;
public String str[]=new String[300];

public String strname[]=new String[300];
@Override
protected void onCreate(Bundle savedInstanceState) 
{ 
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_dir_name);
	String post=getIntent().getStringExtra("post");
	if(post.contains("1"))
	{
		table="dir";
	url+="V.php3";
	}
		if(post.equals("0"))
			
		{
			table="dir";
			url+="C.php3";	
			
		}
			if(post.equals("2"))
			{
				table="Department";
				url+="Department.php3";
			}
				if(post.equals("3"))
				{
					table="Department";
					url+="Department.php3";
				}
  l=(ListView) findViewById(R.id.lvName);
	try{
	accessWebService(); 
	
	}
	catch(Exception e)
	{
		
		Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_LONG).show();
	}
}
@Override
public boolean onCreateOptionsMenu(Menu menu)
{   // Inflate the menu; this adds items to the action bar if it is present.   
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}
// Async Task to access the web
private class JsonReadTask extends AsyncTask<String, Void, String>
{
	@Override
	protected String doInBackground(String... params) 
	{    
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(params[0]);
		try {
			HttpResponse response = httpclient.execute(httppost);
			jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
			}
		catch (ClientProtocolException e)
		{     e.printStackTrace();  
			}
		catch (Exception e) 
		{     e.printStackTrace();  
		}
		return null;
		}
	private StringBuilder inputStreamToString(InputStream is)
	{
		String rLine = "";    
		StringBuilder answer = new StringBuilder();   
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));    
		try {     
			while ((rLine = rd.readLine()) != null)
			{  
				answer.append(rLine); 
				}
			}
		catch (IOException e)
		{     // e.printStackTrace(); 
			Toast.makeText(getApplicationContext(),       "Error..." + e.toString(), Toast.LENGTH_LONG).show();   
			}
		return answer;
		}
	@Override
	protected void onPostExecute(String result)
	{
		ListDrwaer();
		}
	}
// end async task  
public void accessWebService()
{
	JsonReadTask task = new JsonReadTask();   
	//passes values for the urls string array 
	task.execute(new String[] { url }); 
	} 
// build hash set for list view 
public void ListDrwaer() 
{   List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();
try { 
	JSONObject jsonResponse = new JSONObject(jsonResult);
	JSONArray jsonMainNode = jsonResponse.optJSONArray(table);
	for (int i = 0; i < jsonMainNode.length(); i++) 
	{     JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
	name = jsonChildNode.optString("Name");

	
	employeeList.add(createEmployee("employees", name));
	}
	}
catch (Exception e) 
{    
	Toast.makeText(getApplicationContext(), "Error" + e.toString(),Toast.LENGTH_SHORT).show();  
	}
try{
SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList,android.R.layout.simple_list_item_1,new String[] { "employees" }, new int[] { android.R.id.text1 });   
l.setAdapter(simpleAdapter);
l.setOnItemClickListener(new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(getApplicationContext(), DirName.class);
		intent.putExtra("post",name);
		
		startActivity(intent);
	}
});
}
catch(Exception e){
	Toast.makeText(getApplicationContext(), "Error" + e.toString(),Toast.LENGTH_SHORT).show();
}
}
private HashMap<String, String> createEmployee(String name, String number)
{
	HashMap<String, String> employeeNameNo = new HashMap<String, String>(); 
	employeeNameNo.put(name, number);
	return employeeNameNo;
		}

}





package com.fightfleet.fightfleetclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class ConceptActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_concept, menu);
        return true;
    }
    
    public void testGet(View view) {
    	try
    	{
	    	GetTask getTask = new GetTask();
	    	URL createUser = new URL("http://fightfleetapi.apphb.com/user/createuser");
	    	getTask.execute(createUser);
    	}
    	catch (Exception ex)
    	{
    		
    	}
    }
    
    public void testPost(View view){
    	
    }
    
    private class GetTask extends AsyncTask<URL, Void, String> {

    	@Override
    	protected String doInBackground(URL... params) {
    		try
    		{
    			StringBuilder sb = new StringBuilder();
    		    //URL createUser = new URL("http://fightfleetapi.apphb.com/user/createuser");
    			for (int i =0; i < params.length; i++){
    				URL createUser =params[i];
    		        URLConnection yc = createUser.openConnection();
    		        BufferedReader in = new BufferedReader(new InputStreamReader(
    		                                    yc.getInputStream()));
    		        String inputLine;
    		        while ((inputLine = in.readLine()) != null) 
    		            sb.append(inputLine);
    		        in.close();
    			}
    		    
    	        return sb.toString();
    		}
    		catch (Exception ex){
    			return "There was an error.\n" + ex.getMessage() + "\n";
    		}
    	}
    	
    	@Override
    	protected void onPostExecute(String result){
          View v= findViewById(R.id.textViewResult);
          TextView txtVw = (TextView)v;
          txtVw.setText(result);
    	}
    }
}

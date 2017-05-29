package com.exa.votingapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import utility.UrlData;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Region;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText aadhar;
Button btn;
String url="http://"+UrlData.ipport+"/E_votting/login.jsp";
ProgressDialog progress;
SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aadhar=(EditText)findViewById(R.id.type_aadhar);
        btn=(Button)findViewById(R.id.auth);
        sharedpreferences = getSharedPreferences("register", Context.MODE_PRIVATE);

        btn.setOnClickListener(new OnClickListener() {
        	

			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Login().execute(aadhar.getText().toString());
				
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public class Login extends AsyncTask<String, String, String>
    {
    	@Override
    	protected void onPreExecute() {
    		progress=new ProgressDialog(MainActivity.this);
    		progress.setCancelable(true);
    		progress.setMessage("Signing up...");
    		progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    		progress.show();
    	}

    	protected String doInBackground(String... params) {
    		// TODO Auto-generated method stub
    		String str=params[0];
    		Log.d("inside inback leejo","inside inback");
    		List<NameValuePair> pdat=new ArrayList<NameValuePair>(7);
    		pdat.add(new BasicNameValuePair("adhar_no",str));
    		
    	
    		HttpClient client=new DefaultHttpClient();
    		HttpPost mypdat=new HttpPost(url);
    		Log.d("iinback","inside inback");
    		try 	
    		{
    			mypdat.setEntity(new UrlEncodedFormEntity(pdat));
    			Log.d("post data","post data");
    		} 
    		catch (UnsupportedEncodingException e)
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		try 
    		{
    			Log.d("inside responce","response");
    			HttpResponse re=client.execute(mypdat);
    			Log.d("inside responce","response1");
    			HttpEntity entity=re.getEntity();
    			Log.d("inside responce","response2");
    			str=EntityUtils.toString(entity);
    			Log.d("response",str);
    			int status=re.getStatusLine().getStatusCode();
    			Log.d("Staus code",""+status);
    			if(status==200)
    			{
    				Log.d("insdie status check",str);
    				//pd.setMessage("sending data complete");
//    				pd.dismiss();
//    				Intent toHome=new Intent(getApplicationContext(),MainActivity.class);
//    				startActivity(toHome);
    				return str;
    				
    			}
    			
    			
    		} 
    		catch (ClientProtocolException e) 
    		{
    			// TODO Auto-generated catch block
    			Log.e("Client","Clientprotocol"+e);
    		} 
    		catch (IOException e) 
    		{
    			// TODO Auto-generated catch block
    			Log.e("Io exception","IO"+e);
    		}
    			
    			//return string if status 200 otherwise null
    		
    		
    		
    		
    		return null;
    	}
    	
    	protected void onPostExecute(String result)
    	{
    		progress.dismiss();
    		if(result == null){
    			Toast.makeText(getApplicationContext(),"no net",Toast.LENGTH_SHORT).show();
    		}else{
        		Log.e("Response",result);
//        		 SharedPreferences.Editor editor = sharedpreferences.edit();
//
//		            editor.putString("region", result);
//		            editor.commit();
    			//Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        		Intent in=new Intent(getApplicationContext(),ShowActivity.class);
        		in.putExtra("data",result);
        		startActivity(in);
        		
    		}
    		
    	}
    	
    }
    
}

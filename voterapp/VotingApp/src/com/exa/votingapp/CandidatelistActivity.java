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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CandidatelistActivity extends Activity implements OnItemSelectedListener{
	  int check=0;
    String[] region = { "1", "2", "3"}; 
	TextView txtcid;
	Spinner spinner1;
String URL1="http://"+UrlData.ipport+"/E_votting/candidate_list.jsp";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_candidatelist);
		
//		txtcid=(TextView) findViewById(R.id.txtcid);
		spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,region);  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        spinner1.setAdapter(aa);  


	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		if(check>0){
		Toast.makeText(getApplicationContext(),"U selected:"+region[arg2] ,Toast.LENGTH_LONG).show();  
	
		new Login().execute(region[arg2]);
		}else{
			check++;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.candidatelist, menu);
		return true;
	}
	public class Login extends AsyncTask<String, String, String>
	{

		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String str="";
			Log.d("inside inback leejo","inside inback");
			List<NameValuePair> pdat=new ArrayList<NameValuePair>(6);
			pdat.add(new BasicNameValuePair("region_code",params[0]));
//			pdat.add(new BasicNameValuePair("source",sourse));
//			pdat.add(new BasicNameValuePair("unitprice",txtPunitprice.getText().toString().trim()));
//			pdat.add(new BasicNameValuePair("quantity",quantity));
//			pdat.add(new BasicNameValuePair("dateproduct",datePpurchae));
			
			
			HttpClient client=new DefaultHttpClient();
			HttpPost mypdat=new HttpPost(URL1);
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
				//Log.d("inside responce","response");
				HttpResponse re=client.execute(mypdat);
				HttpEntity entity=re.getEntity();
				str=EntityUtils.toString(entity);
				//Log.d("response",str);
				int status=re.getStatusLine().getStatusCode();
				//Log.d("Staus code",""+status);
				if(status==200)
				{
					//Log.d("insdie status check",str);
					//pd.setMessage("sending data complete");
//					pd.dismiss();
//					Intent toHome=new Intent(getApplicationContext(),MainActivity.class);
//					startActivity(toHome);
					return str;
					
				}
				
				
			} 
			catch (ClientProtocolException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				//return string if status 200 otherwise null
			
			
			
			
			return null;
		}
		
		protected void onPostExecute(String result)
		{
			super.onPostExecute(result);
			//Log.d("result from",result);
			
			///pd.dismiss();
			if(!result.trim().equals("fail"))
			{
				Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
				
				Intent i=new Intent(CandidatelistActivity.this,SelectCandidateActivity.class);
				i.putExtra("data",result.trim());
				startActivity(i);
				
			}
			else
			{
				Toast.makeText(getApplicationContext(), "You are not registred", Toast.LENGTH_LONG).show();

			}
			
		}
		
	}

}

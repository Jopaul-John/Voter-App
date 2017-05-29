package com.exa.votingapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
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

import bean.Candidate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SelectCandidateActivity extends Activity {
	ListView listview1;
	SharedPreferences sharedpreferences;
	ListView candidate;
	String userid;
	String cid[],cname[],pname[],data[];
	String url="http://"+UrlData.ipport+"/E_votting/candidate_list.jsp";
	String url2="http://"+UrlData.ipport+"/E_votting/vote.jsp";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		candidate=(ListView) findViewById(R.id.listView1);
		sharedpreferences = getSharedPreferences("register", Context.MODE_PRIVATE);
		userid=sharedpreferences.getString("userid","nil");
		Toast.makeText(getApplicationContext(),"" +sharedpreferences.getString("region", "1"),Toast.LENGTH_LONG).show();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_candidate);
		String reString=getIntent().getStringExtra("data");
		listview1=(ListView) findViewById(R.id.listView1);
//		Type listType=new TypeToken<List<Candidate>>(){}.getType();
//		Gson gson=new Gson();
//		List<Candidate> can=gson.fromJson(reString, listType);
		
		new Login().execute();
		
		listview1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), cid[arg2], Toast.LENGTH_LONG).show();
				new select().execute(cid[arg2]);
			}
		});
//		SharedPreferences.Editor editor = sharedpreferences.edit();
//		
//        editor.putString("region", reg.putRegion_code());
//        editor.commit();
	}

	@Override 
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_candidate, menu);
		return true;
	}
	
	public class Login extends AsyncTask<String, String, String>
	{

		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String str="";
			Log.d("inside inback leejo","inside inback");
			List<NameValuePair> pdat=new ArrayList<NameValuePair>(6);
			
			pdat.add(new BasicNameValuePair("region_code",sharedpreferences.getString("region", "1")));
//			pdat.add(new BasicNameValuePair("source",sourse));
//			pdat.add(new BasicNameValuePair("unitprice",txtPunitprice.getText().toString().trim()));
//			pdat.add(new BasicNameValuePair("quantity",quantity));
//			pdat.add(new BasicNameValuePair("dateproduct",datePpurchae));
			
			
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
				HttpEntity entity=re.getEntity();
				str=EntityUtils.toString(entity);
				Log.d("response",str);
				int status=re.getStatusLine().getStatusCode();
				Log.d("Staus code",""+status);
				if(status==200)
				{
					Log.d("insdie status check",str);
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
			Log.d("result from",result);
			
			///pd.dismiss();
			if(!result.trim().equals("fail"))
			{
				Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
				CourseAdapter cad=new CourseAdapter(result.split(":"), getApplicationContext());
				listview1.setAdapter(cad);
				
				String data[]=result.split(":");
				cid=data[0].split("---");
				cname=data[1].split("---");
				pname=data[2].split("---");
//				Intent i=new Intent(CandidatelistActivity.this,SelectCandidateActivity.class);
//				i.putExtra("data",result.trim());
//				startActivity(i);
				
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Failed..", Toast.LENGTH_LONG).show();

			}
			
		}
		
	}
	public class select extends AsyncTask<String, String, String>
	{

		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String str="";
			//Log.d("inside inback leejo","inside inback");
			List<NameValuePair> pdat=new ArrayList<NameValuePair>(6);
			pdat.add(new BasicNameValuePair("cid",params[0].toString()));
			pdat.add(new BasicNameValuePair("user_id",userid));
			pdat.add(new BasicNameValuePair("region_code",sharedpreferences.getString("region", "1")));
//			pdat.add(new BasicNameValuePair("pass",txtPass.getText().toString().trim()));
//			pdat.add(new BasicNameValuePair("source",sourse));
//			pdat.add(new BasicNameValuePair("unitprice",txtPunitprice.getText().toString().trim()));
//			pdat.add(new BasicNameValuePair("quantity",quantity));
//			pdat.add(new BasicNameValuePair("dateproduct",datePpurchae));
			
			
			HttpClient client=new DefaultHttpClient();
			HttpPost mypdat=new HttpPost(url2);
			//Log.d("iinback","inside inback");
			try 
			{
				mypdat.setEntity(new UrlEncodedFormEntity(pdat));
				//Log.d("post data","post data");
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
			if(!result.trim().equals("failed"))
			{
				if(!result.trim().equals("")){
				Toast.makeText(getApplicationContext(), "Voted", Toast.LENGTH_SHORT).show();
//				String r[]=result.trim().split(":");
//				SharedPreferences sharedPreferences=getSharedPreferences("userdata", Context.MODE_PRIVATE);
//				SharedPreferences.Editor editor=sharedPreferences.edit();
//				editor.putString("rid", r[0]);
//				editor.putString("uname", r[1]);
//				editor.putString("upass", r[2]);
//				editor.putString("unumber", r[3]);
//				editor.commit();
				Intent i=new Intent(SelectCandidateActivity.this,UniqueKeyActivity.class);
				i.putExtra("key",result.trim());
				startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "no net", Toast.LENGTH_SHORT).show();

				}
//				
			}
			else
			{
				Toast.makeText(getApplicationContext(), "You are not registred", Toast.LENGTH_LONG).show();

			}
			
		}
		
	}

}

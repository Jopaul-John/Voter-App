package com.exa.votingapp;

import bean.register;

import com.google.gson.Gson;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {
	TextView aadhar_no, name, gender, address;
	Button button1;
	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		sharedpreferences = getSharedPreferences("register",
				Context.MODE_PRIVATE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
//		aadhar_no = (TextView) findViewById(R.id.aadharno);
		name = (TextView) findViewById(R.id.name);
		gender = (TextView) findViewById(R.id.gender);
		address = (TextView) findViewById(R.id.address);
		button1 = (Button) findViewById(R.id.button1);
		
		
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(ShowActivity.this,SelectCandidateActivity.class);
				 //in.putExtra("regcode",);

				startActivity(in);
			}
		});

		Intent frmIntent=getIntent();
		String data = frmIntent.getStringExtra("data");
		Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();

		String[] vote=data.split(":");
		//Toast.makeText(getApplicationContext(),vote(.l),Toast.LENGTH_SHORT).show();
		//aadhar_no.setText("Voter No : " + vote[1]);
		name.setText("Voter Name : " + vote[2]);
		gender.setText("Gender : " + vote[5]);
		address.setText("Address : " + vote[3]);

		
//		Gson gson = new Gson();
//		register reg = gson.fromJson(data.trim(), register.class);
//
////		
		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putString("userid", vote[0].trim());
		editor.putString("region", vote[6].trim());
		editor.commit();

	}

	private String vote(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private String data(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

}

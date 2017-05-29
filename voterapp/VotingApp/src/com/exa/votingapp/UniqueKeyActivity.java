package com.exa.votingapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class UniqueKeyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unique_key);
		TextView txt=(TextView)findViewById(R.id.unique_key);
		String key=getIntent().getStringExtra("key");
		txt.setText(key);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.unique_key, menu);
		return true;
	}

}

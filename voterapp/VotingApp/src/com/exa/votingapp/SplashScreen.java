package com.exa.votingapp;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;

public class SplashScreen extends Activity {
	Button btnEnter;
	private static int SPLASH_TIME=4000;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_splash_screen);
			
			
			 new Handler().postDelayed(new Runnable() {          
		            @Override
		            public void run() {                         
		                 
		                Intent to_controler=new Intent(getApplicationContext(), MainActivity.class);
		                startActivity(to_controler);
		                finish();
		            }
		        }, SPLASH_TIME);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}

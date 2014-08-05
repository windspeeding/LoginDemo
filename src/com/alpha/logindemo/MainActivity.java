package com.alpha.logindemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Intent in = getIntent();
        if (in.getCharSequenceExtra("usr") != null) {
        	final TextView setmsg = (TextView)findViewById(R.id.welcome);
        	setmsg.setText("Welcome \n "+in.getCharSequenceExtra("usr"));
        	final ImageView image = (ImageView)findViewById(R.id.logo);
        	image.setImageResource(R.drawable.visa_logo);
        }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package com.alpha.logindemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText unmEditText;
	private EditText pwdEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		unmEditText = (EditText) findViewById(R.id.editText_username);
		pwdEditText = (EditText) findViewById(R.id.editText_password);
		
		findViewById(R.id.btn_signup).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 
				final String username = unmEditText.getText().toString();
				final String password = pwdEditText.getText().toString();
				
				if(isValidUsername(username) && isValidPassword(password))
					startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("usr",(CharSequence)username));
        		else 
        			//Toast.makeText(LoginActivity.this,"Invalid UserName or Password", Toast.LENGTH_LONG).show();
    				if (!isValidUsername(username)) {
    					unmEditText.setError("Invalid Username");
    				}
     
    				if (!isValidPassword(password)) {
    					pwdEditText.setError("Invalid Password");
    				}
			}
		});
	}

	// validating user name
	private boolean isValidUsername(String username){
		String USERNAME_PATTERN = "^[a-z0-9_-]{6,15}$";
		
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
	}
	
	// validating password
	private boolean isValidPassword(String password){
		if(password != null && password.length() > 6) {
		return true;
		}
		return false;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}

package com.example.freebusy;

import Model.FreeBusyDataSource;
import Model.User;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView login_button;
    private FreeBusyDataSource datasource=new FreeBusyDataSource(this);
    private EditText emailAddress_field;
    private EditText password_field;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        login_button = (ImageView) findViewById(R.id.login_button);
        emailAddress_field = (EditText) findViewById(R.id.emailAddress_field);
        password_field = (EditText) findViewById(R.id.password_field);

        
        addListeners();
    }

    private void addListeners(){
    	login_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//check logged in
				String email=emailAddress_field.getText().toString();
				if(datasource.getUserType(email)==0)
				{//user student
					//add db
					User currUser=datasource.getUser(email);
					Intent myIntent = new Intent(MainActivity.this, DashboardActivity.class);
					myIntent.putExtra("user", String.valueOf(currUser.getId()));
					startActivity(myIntent);
				}
				else if(datasource.getUserType(email)==1)
				{
					//admin
					User currUser=datasource.getUser(email);
				
					Intent myIntent = new Intent(MainActivity.this, ProfActivity.class);
					myIntent.putExtra("user", String.valueOf(currUser.getId()));
					startActivity(myIntent);
					//Log.e("hehe", "hehe");
				}
				else
				{
					
				}
				
			}
    	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

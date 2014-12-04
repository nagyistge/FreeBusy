package com.example.freebusy;

import Model.Alert;
import Model.FreeBusyDataSource;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Spinner;

public class ConsultActivity extends Activity{
	private String name,u_id="0";
	private Spinner number_spinner;
	private Spinner reasons_spinner;
	private ImageView submit_button;

	private FreeBusyDataSource datasource=new FreeBusyDataSource(this);
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        ActionBar actionBar = getActionBar();
		actionBar.hide();
        Intent i = getIntent();
        name = i.getStringExtra("name");
        u_id=i.getStringExtra("u_id");
       // Log.e(u_id,"qwe");
        number_spinner = (Spinner) findViewById(R.id.number_spinner);
        reasons_spinner = (Spinner) findViewById(R.id.reason_spinner);
        
        
        
        submit_button = (ImageView) findViewById(R.id.submit_button);
        addListeners();
    }

	private void addListeners() {
		submit_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// add to database 'number' and 'reason'
				String number = number_spinner.getSelectedItem().toString();
		        String reason = reasons_spinner.getSelectedItem().toString();
		        Alert alert=new Alert();
		        alert.setAlertCount(Integer.parseInt(number));
		        alert.setAlertReason(reason);
		        alert.setAlertProfID(datasource.getIDbyName(name));
		        alert.setAlertUserID(Integer.parseInt(u_id));
		       // Log.e(alert.getAlertProfID()+"","hashd");
		        datasource.addAlert(alert);
				Intent myIntent = new Intent(ConsultActivity.this, DashboardActivity.class);
				myIntent.putExtra("user", u_id);
				startActivity(myIntent);
				finish();
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

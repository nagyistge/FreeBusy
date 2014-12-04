package com.example.freebusy;

import java.util.List;
import Model.FreeBusyDataSource;
import Model.User;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DashboardActivity extends Activity {
	private ListView ProfessorsListView;
	private FreeBusyDataSource datasource = new FreeBusyDataSource(this);
	private ImageView consult_button;
	private ImageView schedule_button;
	private ImageView toggle_status;
	private String user_id;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		ActionBar actionBar = getActionBar();
		actionBar.hide();
		Intent i = getIntent();
		user_id = i.getStringExtra("user");
		// Log.e(user_id,"first");
		datasource.open();
		
		
		List<User> professors = datasource.getAllProfessors(datasource
				.getAllProfessorsID(Integer.parseInt(user_id)));
		int cou=professors.size();
		int q=0;
		while(q<cou)
		{
			professors.get(q).setToggleStatus(datasource.getStatus(professors.get(q).getId()));
		
		q++;
		}
		
		ProfessorsListView = (ListView) findViewById(R.id.ProfessorsListView);
		CustomItemAdapter adapter = new CustomItemAdapter(getBaseContext(),
				R.layout.professors_list, professors);
		ProfessorsListView.setAdapter(adapter);
		ProfessorsListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub
						TextView tv = (TextView) arg1
								.findViewById(R.id.professor_name);
						String name = tv.getText().toString();
						// Log.e("position", ""+name);
						consult_button = (ImageView) arg1
								.findViewById(R.id.consult_button);
						schedule_button = (ImageView) arg1
								.findViewById(R.id.schedule_button);
						toggle_status = (ImageView) arg1
								.findViewById(R.id.toggle_image);
						addListeners(name);
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void addListeners(final String name) {
			consult_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
					Intent myIntent = new Intent(DashboardActivity.this, ConsultActivity.class);
					myIntent.putExtra("name", name);
					myIntent.putExtra("u_id", user_id);
					startActivity(myIntent);
				//	finish();
				}
	    	});
			schedule_button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
						
					Intent myIntent = new Intent(DashboardActivity.this, ScheduleActivity.class);
					startActivity(myIntent);
					
					}
		    	});
		}
}

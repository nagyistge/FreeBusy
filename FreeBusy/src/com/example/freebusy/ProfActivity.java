package com.example.freebusy;

import java.util.List;

import Model.Alert;
import Model.FreeBusyDataSource;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class ProfActivity extends Activity {

	private FreeBusyDataSource datasource = new FreeBusyDataSource(this);
	private String user_id;
	private int status = 0;
	private ImageView ImageView1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prof);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		Intent i = getIntent();
		user_id = i.getStringExtra("user");
		status=datasource.getStatus(Integer.parseInt(user_id));
		showBG();
		final List<Alert> alerts = datasource.getAlerts(Integer
				.parseInt(user_id));
		if (alerts.isEmpty()) {
			// do nothing
		} else {
			// show dialog
			int count = alerts.size();
			int j = 0;
			while (j < count) {
				AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
				builder1.setMessage(datasource.getNamebyID(alerts.get(j)
						.getAlertUserID())
						+ " wants to consult regarding "
						+ alerts.get(j).getAlertReason()
						+ "\n There are "
						+ alerts.get(j).getAlertCount()
						+ " student/s all in all.");
				builder1.setCancelable(true);
				final int abc = j;
				builder1.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								alerts.get(abc).setAlertResponse(1);
								datasource.updateAlertResponse(alerts.get(abc));
								dialog.cancel();
							}
						});
				builder1.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								alerts.get(abc).setAlertResponse(0);
								datasource.updateAlertResponse(alerts.get(abc));
								dialog.cancel();
							}
						});

				AlertDialog alert11 = builder1.create();
				alert11.show();
				j++;
			}
		}
		ImageView1 = (ImageView) findViewById(R.id.imageView1);

		addListeners();
	}

	private void addListeners() {
		ImageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				toggleBackground();
			}
		});
	}

	protected void toggleBackground() {
		// TODO Auto-generated method stub
		if (status == 1) {
			status = 0;
			View view = (View) findViewById(R.id.rLayout);
			datasource.ToggleStatus(Integer.parseInt(user_id), status);
			view.setBackgroundColor(Color.parseColor("#ff0000"));
		} else {
			status = 1;
			View view = (View) findViewById(R.id.rLayout);
			datasource.ToggleStatus(Integer.parseInt(user_id), status);
			view.setBackgroundColor(Color.parseColor("#00C78C"));
		}
	}
	protected void showBG() {
		// TODO Auto-generated method stub
		if (status == 1) {
			View view = (View) findViewById(R.id.rLayout);
			view.setBackgroundColor(Color.parseColor("#00C78C"));
		} else {
			View view = (View) findViewById(R.id.rLayout);
			view.setBackgroundColor(Color.parseColor("#ff0000"));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
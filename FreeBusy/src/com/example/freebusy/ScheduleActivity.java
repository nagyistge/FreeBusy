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

public class ScheduleActivity extends Activity {

	private FreeBusyDataSource datasource = new FreeBusyDataSource(this);
	private String user_id;
	private int status = 0;
	private ImageView ImageView1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scheduleview);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		addListeners();
	}

	private void addListeners() {
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
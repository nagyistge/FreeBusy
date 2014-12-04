package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DAO.DataSource;
import DAO.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class FreeBusyDataSource extends DataSource {
	private SQLiteDatabase database;

	public FreeBusyDataSource(Context context) {
		super(context);

	}

	public int getID(String email) {
		int i = 0;
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT id FROM " + DatabaseHelper.TABLE_USER
				+ " where email= \"" + email + "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			i = cursor.getInt(0);
		}
		return i;
	}

	public User getUser(String email) {
		int i = 0;
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_USER
				+ " where email= \"" + email + "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);
		User a = new User();
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			a.setId(cursor.getInt(0));
			a.setName(cursor.getString(1));
			a.setEmailADD(cursor.getString(2));
			a.setPass(cursor.getString(3));
			a.setCollege(cursor.getString(4));
			a.setType(cursor.getInt(5));
		}
		return a;
	}

	public List<Integer> getAllProfessorsID(int userID) {
		List<Integer> profListID = new ArrayList<Integer>();
		// Select All Query
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT pId  FROM "
				+ DatabaseHelper.TABLE_STUDENTPROF + " inner join "
				+ DatabaseHelper.TABLE_USER + " on "
				+ DatabaseHelper.TABLE_USER + ".id="
				+ DatabaseHelper.TABLE_STUDENTPROF + ".sId" + " where "
				+ DatabaseHelper.TABLE_USER + ".id=" + userID;
		Cursor cursor = database.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				profListID.add((cursor.getInt(0)));

			} while (cursor.moveToNext());
		}
		return profListID;

	}

	public List<User> getAllProfessors(List<Integer> profIDs) {
		List<User> profList = new ArrayList<User>();
		// Select All Query
		if (database == null) {
			this.database = reopen();
		}
		int count = profIDs.size();
		int i = 0;
		while (i < count) {
			String selectQuery = "SELECT *  FROM " + DatabaseHelper.TABLE_USER
					+ " where " + DatabaseHelper.TABLE_USER + ".id="
					+ profIDs.get(i);
			Cursor cursor = database.rawQuery(selectQuery, null);
			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					User prof = new User();
					prof.setId(cursor.getInt(0));
					prof.setName(cursor.getString(1));
					prof.setEmailADD(cursor.getString(2));
					prof.setPass(cursor.getString(3));
					prof.setCollege(cursor.getString(4));
					prof.setType(cursor.getInt(5));
					profList.add(prof);

				} while (cursor.moveToNext());
			}
			i++;
		}
		return profList;

	}

	public void addSchedule(Schedule s, User u) {
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.CLASSSCHED_STARTDATE, s.getStartDate()
				.toString());
		values.put(DatabaseHelper.CLASSSCHED_ENDDATE, s.getEndDate().toString());
		values.put(DatabaseHelper.CLASSSCHED_PID, u.getId());
		// Inserting Row
		if (database == null) {
			this.database = reopen();
		}
		database.insert(DatabaseHelper.TABLE_CLASSCHEDULE, null, values);

		// Closing database connection
	}

	public void getDates(int pID) {
		int i = 0;
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT * FROM "
				+ DatabaseHelper.TABLE_CLASSCHEDULE + " where pID= \"" + pID
				+ "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				Log.e(cursor.getLong(1) + "hehe", "hello");
				Log.e(cursor.getLong(2) + "hehe2", "hello");
				Calendar a = Calendar.getInstance();

			} while (cursor.moveToNext());
		}
	}

	public void addAlert(Alert a) {
		if (database == null) {
			this.database = reopen();
		}
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Alert_Count,
				Integer.toString(a.getAlertCount()));
		values.put(DatabaseHelper.Alert_Reason, a.getAlertReason());
		values.put(DatabaseHelper.Alert_UserID, a.getAlertUserID());
		values.put(DatabaseHelper.Alert_ProfID, a.getAlertProfID());
		values.put(DatabaseHelper.Alert_Response, "-1");

		database.insert(DatabaseHelper.TABLE_ALERT, null, values);

	}

	public int getIDbyName(String name) {
		// TODO Auto-generated method stub
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT id FROM " + DatabaseHelper.TABLE_USER
				+ " where name= \"" + name + "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);
		int i = 0;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				i = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		cursor.close();
		return i;
	}
	public String getNamebyID(int id) {
		// TODO Auto-generated method stub
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT name FROM " + DatabaseHelper.TABLE_USER
				+ " where id= \"" + id + "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);
		String i=null;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				i = cursor.getString(0);

			} while (cursor.moveToNext());
		}
		cursor.close();
		return i;
	}

	public int getUserType(String email) {
		// TODO Auto-generated method stub
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT type FROM " + DatabaseHelper.TABLE_USER
				+ " where email= \"" + email + "\"";
		Cursor cursor = database.rawQuery(selectQuery, null);
		int i = -1;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				i = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		cursor.close();
		return i;
	}
	public List<Alert> getAlerts(int u_id)
	{
		List<Alert> AlertList = new ArrayList<Alert>();
		// Select All Query
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT * from "+DatabaseHelper.TABLE_ALERT+" where alertProfID="+u_id+" AND alertResponse=-1"; 
		Cursor cursor = database.rawQuery(selectQuery, null);
		
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Alert alert=new Alert();
				alert.setAlertID(cursor.getInt(0));
				alert.setAlertUserID(cursor.getInt(1));
				cursor.getInt(2);
				alert.setAlertCount(cursor.getInt(3));
				alert.setAlertReason(cursor.getString(4));
				cursor.getInt(5);
				Log.e("hello",alert.getAlertReason());
				AlertList.add(alert);
			
			} while (cursor.moveToNext());
			
				cursor.close();
			
		}
		return AlertList;
	}
	
	public void updateAlertResponse(Alert a)
	{
		ContentValues values = new ContentValues();
	    values.put(DatabaseHelper.Alert_Response, a.getAlertResponse());
	    
	    // Inserting Row
	    if(database==null){
		    this.database=reopen();
	    }
	    database.update(DatabaseHelper.TABLE_ALERT, values, "alertID= "+a.getAlertID(), null);
	}
	
	public void ToggleStatus(int profID, int status)
	{
		if (database == null) {
			this.database = reopen();
		}
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Toggle_ProfID,profID);
		values.put(DatabaseHelper.Toggle_Status, status);
	
		database.insert(DatabaseHelper.TABLE_TOGGLE, null, values);
	}
	public int getStatus(int id)
	{
		if (database == null) {
			this.database = reopen();
		}
		String selectQuery = "SELECT toggleID, toggleStatus FROM " + DatabaseHelper.TABLE_TOGGLE
				+ " where toggleProfID= \"" + id + "\""+" ORDER BY toggleID DESC LIMIT 1";
		Cursor cursor = database.rawQuery(selectQuery, null);
		int i=1;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				
				i=cursor.getInt(1);
			} while (cursor.moveToNext());
		}
		cursor.close();
		return i;
	}
	

}

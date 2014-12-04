package DAO;

//import android.content.ContentValues;
import java.util.Calendar;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "FreeBusy";

	// tables name
	public static final String TABLE_USER = "user";
	public static final String TABLE_CLASSCHEDULE = "classSchedule";
	public static final String TABLE_DAY = "day";
	public static final String TABLE_TIME = "time";
	public static final String TABLE_STUDENTPROF = "studprof";
	public static final String TABLE_SCHEDDAY = "schedday";
	public static final String TABLE_SCHEDTIME = "schedtime";
	public static final String TABLE_TOGGLE = "toggle";
	public static final String TABLE_ALERT = "alert";

	// USER Table Columns names
	public static final String USER_ID = "id";
	public static final String USER_EMAILADD = "email";
	public static final String USER_NAME = "name";
	public static final String USER_PASS = "password";
	public static final String USER_COLLEGE = "college";
	public static final String USER_TYPE = "type";
	// ClassSCHEDULE Table Column Names
	public static final String CLASSSCHED_ID = "classSchedID";
	public static final String CLASSSCHED_STARTDATE = "startDate";
	public static final String CLASSSCHED_ENDDATE = "endDate";
	public static final String CLASSSCHED_PID = "pID";
	// Toggle Table Column Names
	public static final String Toggle_ID = "toggleID";
	public static final String Toggle_ProfID = "toggleProfID";
	public static final String Toggle_Date = "toggleDate";
	public static final String Toggle_Time = "toggleTime";
	public static final String Toggle_Status = "toggleStatus";
	// Alert Table Column Names
	public static final String Alert_ID = "alertID";
	public static final String Alert_Count = "alertCount";
	public static final String Alert_UserID = "alertUID";
	public static final String Alert_ProfID = "alertProfID";
	public static final String Alert_Reason = "alertReason";
	public static final String Alert_Response = "alertResponse";

	// Day Table Column Names
	public static final String DAY_ID = "DayID";
	public static final String DAY_NAME = "DayValue";

	// Time Table Column Names
	public static final String TIME_ID = "TimeID";
	public static final String TIME_NAME = "TimeValue";

	// stud_prof Table Column Names
	public static final String USER_STUDENT = "sId";
	public static final String USER_PROFESSOR = "pId";
	// sched_day Table Column Names
	public static final String SCHEDDAY_CLASSID = "sdcId";
	public static final String SCHEDDAY_DAYID = "sddId";

	// sched_time Table Column Names
	public static final String SCHEDTIME_CLASSID = "stcId";
	public static final String SCHEDTIME_STARTTIMEID = "sttStartId";
	public static final String SCHEDTIME_ENDTIMEID = "sttEndId";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createUserTable = "CREATE TABLE IF NOT EXISTS " + TABLE_USER
				+ "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ USER_NAME + " TEXT, " + USER_EMAILADD + " TEXT, " + USER_PASS
				+ " TEXT, " + USER_COLLEGE + " TEXT, " + USER_TYPE + " INTEGER"
				+ ")";

		String createScheduleTable = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_CLASSCHEDULE + "(" + CLASSSCHED_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + CLASSSCHED_STARTDATE
				+ " NUMERIC, " + CLASSSCHED_ENDDATE + " NUMERIC, " + CLASSSCHED_PID
				+ " INTEGER" + ")";

		String createDayTable = "CREATE TABLE IF NOT EXISTS " + TABLE_DAY + "("
				+ DAY_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " + DAY_NAME
				+ " TEXT" + ")";

		String createTimeTable = "CREATE TABLE IF NOT EXISTS " + TABLE_TIME
				+ "(" + TIME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ TIME_NAME + " TIME" + ")";

		String createStud_ProfTable = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_STUDENTPROF + " (" + USER_STUDENT
				+ " INTEGER NOT NULL, " + USER_PROFESSOR + " INTEGER NOT NULL "
				+ ")";

		String createsched_dayTable = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_SCHEDDAY + " (" + SCHEDDAY_CLASSID
				+ "  INTEGER NOT NULL, " + SCHEDDAY_DAYID
				+ "  INTEGER NOT NULL " + ")";

		String createsched_timeTable = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_SCHEDTIME + " (" + SCHEDTIME_CLASSID
				+ "  INTEGER NOT NULL, " + SCHEDTIME_STARTTIMEID
				+ "  INTEGER NOT NULL, " + SCHEDTIME_ENDTIMEID
				+ "  INTEGER NOT NULL " + ")";

		String createToggleTable = "CREATE TABLE IF NOT EXISTS " + TABLE_TOGGLE
				+ " (" + Toggle_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Toggle_ProfID + " INTEGER, " + Toggle_Date + " NUMERIC, "
				+ Toggle_Time + " TIME, " + Toggle_Status + " INTEGER" + ")";
		String createAlertTable = "CREATE TABLE IF NOT EXISTS " + TABLE_ALERT
				+ " (" + Alert_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Alert_UserID + " INTEGER, " + Alert_ProfID + " INTEGER, "
				+ Alert_Count + " INTEGER, " + Alert_Reason + " TEXT, "
				+ Alert_Response + " INTEGER" + ")";

		db.execSQL(createUserTable);
		db.execSQL(createScheduleTable);
		db.execSQL(createDayTable);
		db.execSQL(createTimeTable);
		db.execSQL(createStud_ProfTable);
		db.execSQL(createsched_dayTable);
		db.execSQL(createsched_timeTable);
		db.execSQL(createToggleTable);
		db.execSQL(createAlertTable);

		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.DAY_NAME, "Monday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Tuesday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Wednesday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Thurdsday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Friday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Saturday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);
		values.put(DatabaseHelper.DAY_NAME, "Sunday");
		db.insert(DatabaseHelper.TABLE_DAY, null, values);

		values = new ContentValues();
		values.put(DatabaseHelper.TIME_NAME, "7:30");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "7:45");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "8:00");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "8:15");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "8:30");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "8:45");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "9:00");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);
		values.put(DatabaseHelper.TIME_NAME, "9:15");
		db.insert(DatabaseHelper.TABLE_TIME, null, values);

		values = new ContentValues();
		values.put(DatabaseHelper.USER_EMAILADD, "j");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "0");
		values.put(DatabaseHelper.USER_COLLEGE, "CCS");
		values.put(DatabaseHelper.USER_NAME, "Jeffrey Dy");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values = new ContentValues();
		values.put(DatabaseHelper.USER_EMAILADD, "t");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "0");
		values.put(DatabaseHelper.USER_COLLEGE, "CCS");
		values.put(DatabaseHelper.USER_NAME, "Timothy Rodriguez");
		db.insert(DatabaseHelper.TABLE_USER, null, values);

		
		values.put(DatabaseHelper.USER_EMAILADD, "abc");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "CLA");
		values.put(DatabaseHelper.USER_NAME, "Brianne Samson");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc1");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "CCS");
		values.put(DatabaseHelper.USER_NAME, "Clement Ong");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc2");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "COB");
		values.put(DatabaseHelper.USER_NAME, "Courtney Ngo");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc3");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "GCOE");
		values.put(DatabaseHelper.USER_NAME, "Jay Arcilla");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc4");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "CCS");
		values.put(DatabaseHelper.USER_NAME, "Ralph Regalado");
		db.insert(DatabaseHelper.TABLE_USER, null, values);

		

		values.put(DatabaseHelper.USER_EMAILADD, "abc5");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "CCS");
		values.put(DatabaseHelper.USER_NAME, "RJ Molano");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc6");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "COB");
		values.put(DatabaseHelper.USER_NAME, "ABC");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc7");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "SOE");
		values.put(DatabaseHelper.USER_NAME, "Jocelynn Cu");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc8");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "SOE");
		values.put(DatabaseHelper.USER_NAME, "Ayami Lui");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values.put(DatabaseHelper.USER_EMAILADD, "abc9");
		values.put(DatabaseHelper.USER_PASS, "1234");
		values.put(DatabaseHelper.USER_TYPE, "1");
		values.put(DatabaseHelper.USER_COLLEGE, "CED");
		values.put(DatabaseHelper.USER_NAME, "Timothy Rodriguez");
		db.insert(DatabaseHelper.TABLE_USER, null, values);
		
		values = new ContentValues();
		
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "3");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "4");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "5");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "6");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "7");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "8");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "9");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "10");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "1");
		values.put(DatabaseHelper.USER_PROFESSOR, "11");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		
		
		values = new ContentValues();
		values.put(DatabaseHelper.USER_STUDENT, "2");
		values.put(DatabaseHelper.USER_PROFESSOR, "8");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "2");
		values.put(DatabaseHelper.USER_PROFESSOR, "9");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "2");
		values.put(DatabaseHelper.USER_PROFESSOR, "10");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		values.put(DatabaseHelper.USER_STUDENT, "2");
		values.put(DatabaseHelper.USER_PROFESSOR, "11");
		db.insert(DatabaseHelper.TABLE_STUDENTPROF, null, values);
		
		
		values = new ContentValues();
		values.put(DatabaseHelper.CLASSSCHED_PID, "2");
		Calendar a=Calendar.getInstance();
		a.set(2014, 11, 1);
		long milli=a.getTimeInMillis();
		values.put(DatabaseHelper.CLASSSCHED_STARTDATE, Long.toString(milli));
		a.set(2014, 12, 31);
		milli=a.getTimeInMillis();
		values.put(DatabaseHelper.CLASSSCHED_ENDDATE, Long.toString(milli));
		db.insert(DatabaseHelper.TABLE_CLASSCHEDULE, null, values);
		
		values.put(DatabaseHelper.CLASSSCHED_PID, "3");
		a.set(2015, 01, 1);
		milli=a.getTimeInMillis();
		values.put(DatabaseHelper.CLASSSCHED_STARTDATE, Long.toString(milli));
		a.set(2015, 03, 31);
		milli=a.getTimeInMillis();
		values.put(DatabaseHelper.CLASSSCHED_ENDDATE, Long.toString(milli));
		db.insert(DatabaseHelper.TABLE_CLASSCHEDULE, null, values);
		
		
		
		values = new ContentValues();
		values.put(DatabaseHelper.SCHEDDAY_CLASSID, "1");
		values.put(DatabaseHelper.SCHEDDAY_DAYID, "1");
		db.insert(DatabaseHelper.TABLE_SCHEDDAY, null, values);
		
		values.put(DatabaseHelper.SCHEDDAY_CLASSID, "1");
		values.put(DatabaseHelper.SCHEDDAY_DAYID, "3");
		db.insert(DatabaseHelper.TABLE_SCHEDDAY, null, values);
		
		//Log.e("DONE", "DONE");
	

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Steps to upgrade the database for the new version ...
	}

}
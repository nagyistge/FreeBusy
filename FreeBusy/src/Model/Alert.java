package Model;

import DAO.DatabaseHelper;
import android.content.ContentValues;

public class Alert {
	private int AlertID;
	private int AlertCount;
	private int AlertUserID;
	private int AlertProfID;
	private String AlertReason;
	private int AlertResponse;

	public int getAlertID() {
		return AlertID;
	}

	public void setAlertID(int alertID) {
		AlertID = alertID;
	}

	public int getAlertCount() {
		return AlertCount;
	}

	public void setAlertCount(int alertCount) {
		AlertCount = alertCount;
	}

	public int getAlertUserID() {
		return AlertUserID;
	}

	public void setAlertUserID(int alertUserID) {
		AlertUserID = alertUserID;
	}

	public int getAlertProfID() {
		return AlertProfID;
	}

	public void setAlertProfID(int alertProfID) {
		AlertProfID = alertProfID;
	}

	public String getAlertReason() {
		return AlertReason;
	}

	public void setAlertReason(String alertReason) {
		AlertReason = alertReason;
	}

	public int getAlertResponse() {
		return AlertResponse;
	}

	public void setAlertResponse(int alertResponse) {
		AlertResponse = alertResponse;
	}

	
	
}

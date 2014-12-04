package Model;

public class User {
	private int id;
	private String emailADD;
	private String pass;
	private String college;
	private int type;
	private String name;
	private int ToggleStatus;
	public int getToggleStatus() {
		return ToggleStatus;
	}
	public void setToggleStatus(int toggleStatus) {
		ToggleStatus = toggleStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailADD() {
		return emailADD;
	}
	public void setEmailADD(String emailADD) {
		this.emailADD = emailADD;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}

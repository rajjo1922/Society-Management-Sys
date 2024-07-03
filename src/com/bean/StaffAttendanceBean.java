package com.bean;

public class StaffAttendanceBean {
	private int staff_id;
	private String date;
	private String attendance;
	private String[] idsToMark;
	private String from_date;
	private String to_date;
	private String work;

	public int getStaff_id() {
		return staff_id;
	}

	public String getDate() {
		return date;
	}

	public String getAttendance() {
		return attendance;
	}

	public String[] getIdsToMark() {
		return idsToMark;
	}

	public String getFrom_date() {
		return from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public void setIdsToMark(String[] idsToMark) {
		this.idsToMark = idsToMark;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public StaffAttendanceBean() {
		super();
	}

	public StaffAttendanceBean(String from_date, String to_date, String work) {
		super();
		this.from_date = from_date;
		this.to_date = to_date;
		this.work = work;
	}

	public StaffAttendanceBean(int staff_id, String date, String attendance) {
		super();
		this.staff_id = staff_id;
		this.date = date;
		this.attendance = attendance;
	}

	public StaffAttendanceBean(String[] idsToMark, String date) {
		super();
		this.date = date;
		this.idsToMark = idsToMark;
	}
}

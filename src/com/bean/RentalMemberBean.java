package com.bean;

public class RentalMemberBean {
	private int renter_id;
	private String renter_name;
	private String gender;
	private String dob;
	private String mobile_no;
	private String aadhar_no;
	private String email_id;
	private int wing_id;
	private String wing_name;
	private int flat_id;
	private int flat_no;
	private String on_rent_date;
	private int flat_maintenance;
	private String leave_date;

	public int getRenter_id() {
		return renter_id;
	}

	public void setRenter_id(int renter_id) {
		this.renter_id = renter_id;
	}

	public String getRenter_name() {
		return renter_name;
	}

	public void setRenter_name(String renter_name) {
		this.renter_name = renter_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getWing_id() {
		return wing_id;
	}

	public void setWing_id(int wing_id) {
		this.wing_id = wing_id;
	}

	public String getWing_name() {
		return wing_name;
	}

	public void setWing_name(String wing_name) {
		this.wing_name = wing_name;
	}

	public int getFlat_id() {
		return flat_id;
	}

	public void setFlat_id(int flat_id) {
		this.flat_id = flat_id;
	}

	public int getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public String getOn_rent_date() {
		return on_rent_date;
	}

	public void setOn_rent_date(String on_rent_date) {
		this.on_rent_date = on_rent_date;
	}

	public int getFlat_maintenance() {
		return flat_maintenance;
	}

	public void setFlat_maintenance(int flat_maintenance) {
		this.flat_maintenance = flat_maintenance;
	}

	public String getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(String leave_date) {
		this.leave_date = leave_date;
	}

	public RentalMemberBean() {
		super();
	}

	public RentalMemberBean(String renter_name, String gender, String dob, String mobile_no, String aadhar_no,
			String email_id, int wing_id, int flat_id, String on_rent_date, int flat_maintenance) {
		super();
		this.renter_name = renter_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.email_id = email_id;
		this.wing_id = wing_id;
		this.flat_id = flat_id;
		this.on_rent_date = on_rent_date;
		this.flat_maintenance = flat_maintenance;
	}

	public RentalMemberBean(int renter_id, String renter_name, String gender, String dob, String mobile_no,
			String aadhar_no, String email_id, String on_rent_date, int flat_maintenance) {
		super();
		this.renter_id = renter_id;
		this.renter_name = renter_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.email_id = email_id;
		this.on_rent_date = on_rent_date;
		this.flat_maintenance = flat_maintenance;
	}

	
}

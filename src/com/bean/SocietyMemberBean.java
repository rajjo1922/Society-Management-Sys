package com.bean;

public class SocietyMemberBean {
	private int member_id;
	private String owner_name;
	private String gender;
	private String dob;
	private String mobile_no;
	private String aadhar_no;
	private String email_id;
	private int wing_id;
	private String wing_name;
	private int flat_no;
	private int flat_id;
	private String rental_status;
	private int flat_maintenance;
	private String buy_date;
	private String sold_date;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
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

	public int getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public int getFlat_id() {
		return flat_id;
	}

	public void setFlat_id(int flat_id) {
		this.flat_id = flat_id;
	}

	public String getRental_status() {
		return rental_status;
	}

	public void setRental_status(String rental_status) {
		this.rental_status = rental_status;
	}

	public int getFlat_maintenance() {
		return flat_maintenance;
	}

	public void setFlat_maintenance(int flat_maintenance) {
		this.flat_maintenance = flat_maintenance;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public String getSold_date() {
		return sold_date;
	}

	public void setSold_date(String sold_date) {
		this.sold_date = sold_date;
	}

	public SocietyMemberBean() {
		super();
	}

	public SocietyMemberBean(String owner_name, String gender, String dob, String mobile_no, String aadhar_no,
			String email_id, int wing_id, int flat_id, String rental_status, int flat_maintenance,
			String buy_date) {
		super();
		this.owner_name = owner_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.email_id = email_id;
		this.wing_id = wing_id;
		this.flat_id = flat_id;
		this.rental_status = rental_status;
		this.flat_maintenance = flat_maintenance;
		this.buy_date = buy_date;
	}

	public SocietyMemberBean(int member_id, String owner_name, String gender, String dob, String mobile_no,
			String aadhar_no, String email_id, String rental_status, int flat_maintenance,
			String buy_date) {
		super();
		this.member_id = member_id;
		this.owner_name = owner_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.email_id = email_id;
		this.rental_status = rental_status;
		this.flat_maintenance = flat_maintenance;
		this.buy_date = buy_date;
	}
	
	
	
}

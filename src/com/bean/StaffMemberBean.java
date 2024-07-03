package com.bean;

public class StaffMemberBean {

	private int staff_id;
	private String staff_name;
	private String gender;
	private String dob;
	private String mobile_no;
	private String aadhar_no;
	private String work;
	private int payment_amount;
	private String join_date;
	private String leave_date;

	public StaffMemberBean() {
		super();
	}

	public StaffMemberBean(int staff_id, String staff_name, String gender, String dob, String mobile_no,
			String aadhar_no, String work, int payment_amount, String join_date) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.work = work;
		this.payment_amount = payment_amount;
		this.join_date = join_date;
	}

	public StaffMemberBean(String staff_name, String gender, String dob, String mobile_no, String aadhar_no,
			String work, int payment_amount, String join_date) {
		super();
		this.staff_name = staff_name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.aadhar_no = aadhar_no;
		this.work = work;
		this.payment_amount = payment_amount;
		this.join_date = join_date;
	}

	// All Getters Method

	public int getStaff_id() {
		return staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public String getWork() {
		return work;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public String getJoin_date() {
		return join_date;
	}

	public String getLeave_date() {
		return leave_date;
	}

	// All Setters Method

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public void setLeave_date(String leave_date) {
		this.leave_date = leave_date;
	}

}

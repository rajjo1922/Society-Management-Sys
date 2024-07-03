package com.bean;

public class ExpensesBean {
	private int expense_id;
	private String purpose;
	private int wing_id;
	private int flat_id;
	private String wing_name;
	private int flat_no;
	private String done_by;
	private String client_name;
	private String date;
	private int expense_amount;
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getWing_id() {
		return wing_id;
	}
	public void setWing_id(int wing_id) {
		this.wing_id = wing_id;
	}
	public int getFlat_id() {
		return flat_id;
	}
	public void setFlat_id(int flat_id) {
		this.flat_id = flat_id;
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
	public String getDone_by() {
		return done_by;
	}
	public void setDone_by(String done_by) {
		this.done_by = done_by;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(int expense_amount) {
		this.expense_amount = expense_amount;
	}
	
	public ExpensesBean() {
		super();
	}
	public ExpensesBean(String purpose, int wing_id, int flat_id, String done_by, String client_name, String date,
			int expense_amount) {
		super();
		this.purpose = purpose;
		this.wing_id = wing_id;
		this.flat_id = flat_id;
		this.done_by = done_by;
		this.client_name = client_name;
		this.date = date;
		this.expense_amount = expense_amount;
	}

	
	
	
	}

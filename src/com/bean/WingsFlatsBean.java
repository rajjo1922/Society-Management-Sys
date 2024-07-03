package com.bean;

public class WingsFlatsBean {

	private int wing_id;
	private int flat_id;
	private String wing_name;
	private int flat_no;
	private String owner_name;
	private String renter_name;
	private int maintenance;
	private int balance_maintenance;
	private int paid_amount;
	private String paid_date;

	public WingsFlatsBean() {
		super();
	}

	public WingsFlatsBean(int wing_id, int flat_no) {
		super();
		this.wing_id = wing_id;
		this.flat_no = flat_no;
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

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getRenter_name() {
		return renter_name;
	}

	public void setRenter_name(String renter_name) {
		this.renter_name = renter_name;
	}

	public int getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}

	public int getBalance_maintenance() {
		return balance_maintenance;
	}

	public void setBalance_maintenance(int balance_maintenance) {
		this.balance_maintenance = balance_maintenance;
	}

	public int getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(int paid_amount) {
		this.paid_amount = paid_amount;
	}

	public String getPaid_date() {
		return paid_date;
	}

	public void setPaid_date(String paid_date) {
		this.paid_date = paid_date;
	}

}

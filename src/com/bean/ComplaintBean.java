package com.bean;

public class ComplaintBean {

	private int complaint_id;
	private String person_name;
	private String wing;
	private int flat_no;
	private String raised_date;
	private String Description;
	private String status;
	private String[] ids;
	private String[] id_status;

	//
	public int getComplaint_id() {
		return complaint_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public String getWing() {
		return wing;
	}

	public int getFlat_no() {
		return flat_no;
	}

	public String getRaised_date() {
		return raised_date;
	}

	public String getDescription() {
		return Description;
	}

	public String getStatus() {
		return status;
	}

	public String[] getIds() {
		return ids;
	}

	public String[] getId_status() {
		return id_status;
	}

	//
	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public void setRaised_date(String raised_date) {
		this.raised_date = raised_date;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public void setId_status(String[] id_status) {
		this.id_status = id_status;
	}

	public ComplaintBean() {
		super();
	}

	public ComplaintBean(int complaint_id, String person_name, String wing, int flat_no, String raised_date,
			String description, String status) {
		super();
		this.complaint_id = complaint_id;
		this.person_name = person_name;
		this.wing = wing;
		this.flat_no = flat_no;
		this.raised_date = raised_date;
		Description = description;
		this.status = status;
	}

	public ComplaintBean(String person_name, String wing, int flat_no, String raised_date, String description,
			String status) {
		super();
		this.person_name = person_name;
		this.wing = wing;
		this.flat_no = flat_no;
		this.raised_date = raised_date;
		Description = description;
		this.status = status;
	}

	public ComplaintBean(String[] ids) {
		super();
		this.ids = ids;
	}

}

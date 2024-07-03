package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.ComplaintBean;
import com.util.DBConnection;

public class ComplaintDao {

	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public int insertComplaint(ComplaintBean complaintBean) throws SQLException {
		Connection con = DBConnection.getConnection();
		String insert_sql = "INSERT INTO complaints"
				+ "  (person_name, wing, flat_no, raised_date, description, status) VALUES " + " (?, ?, ?, ?, ?, ?);";
		int complaint_id = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, complaintBean.getPerson_name());
			preparedStatement.setString(2, complaintBean.getWing());
			preparedStatement.setInt(3, complaintBean.getFlat_no());
			preparedStatement.setString(4, complaintBean.getRaised_date());
			preparedStatement.setString(5, complaintBean.getDescription());
			preparedStatement.setString(6, complaintBean.getStatus());

			int x = preparedStatement.executeUpdate();
			if (x == 0) {
				return 0;
			}
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				complaint_id = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		System.out.println("Record SuccessFully Added");
		return complaint_id;
	}

	public ArrayList<ComplaintBean> viewall() {
		Connection con = DBConnection.getConnection();
		ArrayList<ComplaintBean> listUsers = new ArrayList<ComplaintBean>();
		try {
			String sql = "select * from complaints";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean cb = new ComplaintBean();
				cb.setComplaint_id(rs.getInt("complaint_id"));
				cb.setPerson_name(rs.getString("person_name"));
				cb.setWing(rs.getString("wing"));
				cb.setFlat_no(rs.getInt("flat_no"));
				cb.setRaised_date(rs.getString("raised_date"));
				cb.setDescription(rs.getString("description"));
				cb.setStatus(rs.getString("status"));

				listUsers.add(cb);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data.");
		}
		return listUsers;
	}

	public boolean delete(ComplaintBean complaintBean) {
		Connection con = DBConnection.getConnection();
		String[] ids = complaintBean.getIds();
		try {
			for (int i = 0; i < ids.length; i++) {
				PreparedStatement preparedStatement = con
						.prepareStatement("DELETE from complaints where complaint_id =" + ids[i]);

				int x = preparedStatement.executeUpdate();
				if (x == 0) {
					System.out.println("Record not Saved");
					return false;
				}
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
			return false;
		}
		System.out.println("Record Successfully Deleted");
		return true;
	}

	public boolean update_status(ComplaintBean complaintBean) {
		Connection con = DBConnection.getConnection();
		String[] ids = complaintBean.getIds();
		try {
			for (int i = 0; i < ids.length; i++) {
				PreparedStatement preparedStatement = con
						.prepareStatement("UPDATE complaints set status='Solved' where complaint_id =" + ids[i]);

				int x = preparedStatement.executeUpdate();
				if (x == 0) {
					System.out.println("Record not Saved");
					return false;
				}
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
			return false;
		}
		System.out.println("Record SuccessFully Updated");
		return true;
	}
}
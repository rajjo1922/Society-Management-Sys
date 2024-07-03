package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.StaffMemberBean;
import com.util.DBConnection;

public class StaffMemberDao {
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public int insertStaff(StaffMemberBean staffMemberBean) throws SQLException {
		Connection con = DBConnection.getConnection();
		String insert_sql = "INSERT INTO staffmembers"
				+ "  (staff_name, gender, dob, mobile_no, aadhar_no, work, payment_amount, join_date) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?);";

		int staff_id = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, staffMemberBean.getStaff_name());
			preparedStatement.setString(2, staffMemberBean.getGender());
			preparedStatement.setString(3, staffMemberBean.getDob());
			preparedStatement.setString(4, staffMemberBean.getMobile_no());
			preparedStatement.setString(5, staffMemberBean.getAadhar_no());
			preparedStatement.setString(6, staffMemberBean.getWork());
			preparedStatement.setInt(7, staffMemberBean.getPayment_amount());
			preparedStatement.setString(8, staffMemberBean.getJoin_date());

			int x = preparedStatement.executeUpdate();
			if (x == 0) {
				return 0;
			}
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				staff_id = generatedKeys.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		System.out.println("Record SuccessFully Added");
		return staff_id;
	}

	public StaffMemberBean findStaff(String staff_name) throws SQLException {
		Connection con = DBConnection.getConnection();
		StaffMemberBean staffMemberBean = new StaffMemberBean();
		try {
			String sql = "select * from staffmembers where staff_name = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, staff_name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				staffMemberBean.setStaff_id(rs.getInt("staff_id"));
				staffMemberBean.setStaff_name(rs.getString("staff_name"));
				staffMemberBean.setGender(rs.getString("gender"));
				staffMemberBean.setDob(rs.getString("dob"));
				staffMemberBean.setMobile_no(rs.getString("mobile_no"));
				staffMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				staffMemberBean.setWork(rs.getString("work"));
				staffMemberBean.setPayment_amount(rs.getInt("payment_amount"));
				staffMemberBean.setJoin_date(rs.getString("join_date"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		}
		return staffMemberBean;
	}

	public boolean updateStaff(StaffMemberBean staffMemberBean) {
		Connection con = DBConnection.getConnection();
		String update_sql = "UPDATE staffmembers set staff_name=?, gender=?, dob=?, mobile_no=?, aadhar_no=?, work=?, join_date=?, payment_amount=? where staff_id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(update_sql);

			preparedStatement.setString(1, staffMemberBean.getStaff_name());
			preparedStatement.setString(2, staffMemberBean.getGender());
			preparedStatement.setString(3, staffMemberBean.getDob());
			preparedStatement.setString(4, staffMemberBean.getMobile_no());
			preparedStatement.setString(5, staffMemberBean.getAadhar_no());
			preparedStatement.setString(6, staffMemberBean.getWork());
			preparedStatement.setString(7, staffMemberBean.getJoin_date());
			preparedStatement.setInt(8, staffMemberBean.getPayment_amount());
			preparedStatement.setInt(9, staffMemberBean.getStaff_id());

			int x = preparedStatement.executeUpdate();
			if (x == 0) {
				System.out.println("Record not Saved");
				return false;
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
			return false;
		}
		System.out.println("Record SuccessFully Updated");
		return true;
	}

	public boolean deleteStaff(String staffName) {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "delete from staffmembers where staff_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, staffName);
			int x = ps.executeUpdate();
			if (x == 0)
				return false;
		} catch (SQLException sq) {
			return false;
		}
		System.out.println("Record Successfully Deleted");
		return true;
	}

	public ArrayList<StaffMemberBean> getAllStaff() {
		Connection con = DBConnection.getConnection();
		ArrayList<StaffMemberBean> listUsers = new ArrayList<StaffMemberBean>();
		try {
			String sql = "SELECT * FROM staffmembers order by work";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StaffMemberBean staffMemberBean = new StaffMemberBean();
				staffMemberBean.setStaff_id(rs.getInt("staff_id"));
				staffMemberBean.setStaff_name(rs.getString("staff_name"));
				staffMemberBean.setGender(rs.getString("gender"));
				staffMemberBean.setDob(rs.getString("dob"));
				staffMemberBean.setMobile_no(rs.getString("mobile_no"));
				staffMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				staffMemberBean.setWork(rs.getString("work"));
				staffMemberBean.setPayment_amount(rs.getInt("payment_amount"));
				staffMemberBean.setJoin_date(rs.getString("join_date"));

				listUsers.add(staffMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data.");
		}
		return listUsers;
	}

	public boolean pastStaffMember(String staff_name, String leave_date) throws SQLException {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "INSERT INTO past_staffmembers (staff_id, staff_name, gender, dob, mobile_no, aadhar_no, work, payment_amount, join_date)SELECT * FROM staffmembers WHERE staff_name='"
					+ staff_name + "'";

			String sql1 = "update past_staffmembers set leave_date = '" + leave_date + "' where staff_name = '"
					+ staff_name + "'";

			String sql2 = "delete from staffmembers where staff_name ='" + staff_name + "'";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			int x = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql1);
			int y = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql2);
			int z = preparedStatement.executeUpdate();

			if (x == 0 && y == 0 && z == 0) {
				return false;
			}
		} catch (SQLException sq) {
			return false;
		}
		System.out.println("Record Successfully Updated");
		return true;
	}

	public ArrayList<StaffMemberBean> findAllPastMember() {
		Connection con = DBConnection.getConnection();
		ArrayList<StaffMemberBean> listUsers = new ArrayList<StaffMemberBean>();
		try {
			String sql = "SELECT * FROM past_staffmembers order by leave_date";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StaffMemberBean staffMemberBean = new StaffMemberBean();
				staffMemberBean.setStaff_id(rs.getInt("staff_id"));
				staffMemberBean.setStaff_name(rs.getString("staff_name"));
				staffMemberBean.setGender(rs.getString("gender"));
				staffMemberBean.setDob(rs.getString("dob"));
				staffMemberBean.setMobile_no(rs.getString("mobile_no"));
				staffMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				staffMemberBean.setWork(rs.getString("work"));
				staffMemberBean.setPayment_amount(rs.getInt("payment_amount"));
				staffMemberBean.setJoin_date(rs.getString("join_date"));
				staffMemberBean.setLeave_date(rs.getString("leave_date"));

				listUsers.add(staffMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data.");
		}
		return listUsers;
	}

}

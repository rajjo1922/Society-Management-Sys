package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.StaffAttendanceBean;
import com.util.DBConnection;

public class StaffAttendanceDao {

	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	// *********************************
	public int insertAttendance(StaffAttendanceBean staffAttendanceBean) throws SQLException {
		Connection con = DBConnection.getConnection();
		String date1 = staffAttendanceBean.getDate();
		String[] idsToMark = staffAttendanceBean.getIdsToMark();

//		String alter_sql = "ALTER TABLE staffattendance ADD COLUMN `" + date + "` VARCHAR(45) NOT NULL DEFAULT 'Absent'";
//		for (int i = 0; i < idsToMark.length; i++) {
//			String update_sql = "UPDATE staffattendance set " + date + "='Present' where staff_id =" + idsToMark[i];
//		}

		int attendance_id = 0;
		try {
			for (int i = 0; i < idsToMark.length; i++) {
				PreparedStatement preparedStatement = con
						.prepareStatement(
								"INSERT INTO staffattendance" + "  (staff_id, date, attendance) VALUES " + " ("
										+ idsToMark[i] + ",'" + date1 + "'" + ", 'Present');",
								Statement.RETURN_GENERATED_KEYS);
				int x = preparedStatement.executeUpdate();
				if (x == 0) {
					return 0;
				}
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					attendance_id = generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception " + e);
			return 0;
		}
		System.out.println("Record SuccessFully Added");
		return attendance_id;
	}

	// *********************************
	public boolean updateAttendnace(StaffAttendanceBean staffAttendanceBean) {
		Connection con = DBConnection.getConnection();

		String update_sql = "UPDATE staffattendance set attendance = ? where staff_id = ? and date = ? ";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(update_sql);

			preparedStatement.setString(1, staffAttendanceBean.getAttendance());
			preparedStatement.setInt(2, staffAttendanceBean.getStaff_id());
			preparedStatement.setString(3, staffAttendanceBean.getDate());

			int x = preparedStatement.executeUpdate();
			if (x == 0) {
				return false;
			}
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return false;
		}
		System.out.println("Record SuccessFully Updated");
		return true;
	}

	public StaffAttendanceBean findStaffAttendance(String from_date, String to_date) throws SQLException {
		Connection con = DBConnection.getConnection();
		StaffAttendanceBean staffAttendanceBean = new StaffAttendanceBean();
		try {
			String sql = "select * from staffattendance"; // where date between ? and ? ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1, from_date);
//			preparedStatement.setString(2, to_date);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				staffAttendanceBean.setStaff_id(rs.getInt("staff_id"));
				staffAttendanceBean.setDate(rs.getString("date"));
				staffAttendanceBean.setAttendance(rs.getString("attendance"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Show Data." + sq);
		}
		return staffAttendanceBean;
	}

	// *********************************
	public ArrayList<StaffAttendanceBean> findAttendanceByDate(StaffAttendanceBean staffAttendanceBean) {
		Connection con = DBConnection.getConnection();
		String from_date = staffAttendanceBean.getFrom_date();
		String to_date = staffAttendanceBean.getTo_date();
		String work = staffAttendanceBean.getWork();
		ArrayList<StaffAttendanceBean> listUsers = new ArrayList<StaffAttendanceBean>();
		try {
			String sql = "SELECT a.staff_id,a.date,a.attendance,s.work FROM staffmembers s inner join staffattendance a where a.staff_id = s.staff_id and date between '"
					+ from_date + "' and '" + to_date + "' and work = '" + work + "'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StaffAttendanceBean attend = new StaffAttendanceBean();
				attend.setStaff_id(rs.getInt("staff_id"));
				attend.setDate(rs.getString("date"));
				attend.setAttendance(rs.getString("attendance"));
				attend.setWork(rs.getString("work"));

				listUsers.add(attend);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return listUsers;
	}
}

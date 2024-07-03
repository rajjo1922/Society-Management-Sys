package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bean.RentalMemberBean;
import com.util.DBConnection;

public class RentalMemberDao {
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public int insertRenter(RentalMemberBean rentalMemberBean) throws SQLException {
		Connection con = DBConnection.getConnection();

		String select_sql = "SELECT * FROM society_flats where flat_id = ? and renter_name='Available';";
		String insert_sql = "INSERT INTO rentalmembers"
				+ "  (renter_name, gender, dob, mobile_no, aadhar_no, email_id, wing_id, flat_id, on_rent_date, flat_maintenance) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String update_sql = "UPDATE society_flats set renter_name=?, maintenance=? where flat_id = ?";

		int renter_id = 0;

		try {
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement(select_sql);
			preparedStatement.setInt(1, rentalMemberBean.getFlat_id());

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				preparedStatement = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setString(1, rentalMemberBean.getRenter_name());
				preparedStatement.setString(2, rentalMemberBean.getGender());
				preparedStatement.setString(3, rentalMemberBean.getDob());
				preparedStatement.setString(4, rentalMemberBean.getMobile_no());
				preparedStatement.setString(5, rentalMemberBean.getAadhar_no());
				preparedStatement.setString(6, rentalMemberBean.getEmail_id());
				preparedStatement.setInt(7, rentalMemberBean.getWing_id());
				preparedStatement.setInt(8, rentalMemberBean.getFlat_id());
				preparedStatement.setString(9, rentalMemberBean.getOn_rent_date());
				preparedStatement.setInt(10, rentalMemberBean.getFlat_maintenance());

				int x = preparedStatement.executeUpdate();
				if (x == 0)
					return 0;
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					renter_id = generatedKeys.getInt(1);
				}
				preparedStatement = con.prepareStatement(update_sql);
				preparedStatement.setString(1, rentalMemberBean.getRenter_name());
				preparedStatement.setInt(2, rentalMemberBean.getFlat_maintenance());
				preparedStatement.setInt(3, rentalMemberBean.getFlat_id());
				preparedStatement.executeUpdate();
			} else
				return 000;
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return 0;
		}
		System.out.println("Record Successfully Inserted");
		return renter_id;
	}

	public RentalMemberBean findRenter(int flat_no) throws SQLException {
		Connection con = DBConnection.getConnection();
		RentalMemberBean rentalMemberBean = new RentalMemberBean();
		try {
			String sql = "select r.renter_id, r.renter_name, r.dob, r.gender, r.mobile_no, r.aadhar_no, r.email_id, r.flat_maintenance, r.on_rent_date, w.wing_name, f.flat_no from rentalmembers r inner join society_flats f on r.flat_id = f.flat_id inner join society_wings w on r.wing_id = w.wing_id where f.flat_no = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, flat_no);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				rentalMemberBean.setRenter_id(rs.getInt("renter_id"));
				rentalMemberBean.setRenter_name(rs.getString("renter_name"));
				rentalMemberBean.setDob(rs.getString("dob"));
				rentalMemberBean.setGender(rs.getString("gender"));
				rentalMemberBean.setMobile_no(rs.getString("mobile_no"));
				rentalMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				rentalMemberBean.setEmail_id(rs.getString("email_id"));
				rentalMemberBean.setWing_name(rs.getString("wing_name"));
				rentalMemberBean.setFlat_no(rs.getInt("flat_no"));
				rentalMemberBean.setOn_rent_date(rs.getString("on_rent_date"));
				rentalMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		}
		return rentalMemberBean;
	}

	public boolean update(RentalMemberBean rentalMemberBean) {
		Connection con = DBConnection.getConnection();
		String update_sql = "UPDATE rentalmembers set renter_name=?, gender=?, dob=?, mobile_no=?, aadhar_no=?, email_id=?, on_rent_date=?, flat_maintenance=? where renter_id = ?";
		String update = "UPDATE society_flats set maintenance=? where renter_name = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(update_sql);

			preparedStatement.setString(1, rentalMemberBean.getRenter_name());
			preparedStatement.setString(2, rentalMemberBean.getGender());
			preparedStatement.setString(3, rentalMemberBean.getDob());
			preparedStatement.setString(4, rentalMemberBean.getMobile_no());
			preparedStatement.setString(5, rentalMemberBean.getAadhar_no());
			preparedStatement.setString(6, rentalMemberBean.getEmail_id());
			preparedStatement.setString(7, rentalMemberBean.getOn_rent_date());
			preparedStatement.setInt(8, rentalMemberBean.getFlat_maintenance());
			preparedStatement.setInt(9, rentalMemberBean.getRenter_id());

			int x = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(update);
			preparedStatement.setInt(1, rentalMemberBean.getFlat_maintenance());
			preparedStatement.setString(2, rentalMemberBean.getRenter_name());
			preparedStatement.executeUpdate();

			if (x == 0) {
				System.out.println("Record not Saved");
				return false;
			}
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return false;
		}
		System.out.println("Record SuccessFully Updated");
		return true;
	}

	public boolean remove(String renterName) {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "delete from rentalmembers where renter_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, renterName);
			int x = ps.executeUpdate();
			if (x == 0)
				return false;
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return false;
		}
		System.out.println("Record Successfully Deleted");
		return true;
	}

	public ArrayList<RentalMemberBean> findAll() {
		Connection con = DBConnection.getConnection();
		ArrayList<RentalMemberBean> listUsers = new ArrayList<RentalMemberBean>();
		try {
			String sql = "select r.renter_name, r.dob, r.gender, r.mobile_no, r.aadhar_no, r.email_id, r.flat_maintenance, r.on_rent_date, w.wing_name, f.flat_no from rentalmembers r inner join society_flats f on r.flat_id = f.flat_id inner join society_wings w on r.wing_id = w.wing_id order by on_rent_date;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RentalMemberBean rentalMemberBean = new RentalMemberBean();
				rentalMemberBean.setRenter_name(rs.getString("renter_name"));
				rentalMemberBean.setDob(rs.getString("dob"));
				rentalMemberBean.setGender(rs.getString("gender"));
				rentalMemberBean.setMobile_no(rs.getString("mobile_no"));
				rentalMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				rentalMemberBean.setEmail_id(rs.getString("email_id"));
				rentalMemberBean.setWing_name(rs.getString("wing_name"));
				rentalMemberBean.setFlat_no(rs.getInt("flat_no"));
				rentalMemberBean.setOn_rent_date(rs.getString("on_rent_date"));
				rentalMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));

				listUsers.add(rentalMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data From Rental Members Table." + sq);
		}
		return listUsers;
	}

	public boolean pastMember(String renterName, String leave_date) throws SQLException {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "INSERT INTO past_rentalmembers (renter_id, renter_name, gender, dob, mobile_no, aadhar_no, email_id, wing_id, flat_id, on_rent_date, flat_maintenance)SELECT * FROM rentalmembers WHERE renter_name='"
					+ renterName + "';";

			String sql1 = "update past_rentalmembers set leave_date = '" + leave_date + "' where renter_name = '"
					+ renterName + "';";

			String sql2 = "update society_flats set renter_name = 'Available', maintenance = 0, balance_maintenance = 0 where renter_name = '"
					+ renterName + "';";

			String sql3 = "delete from rentalmembers where renter_name ='" + renterName + "';";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			int a = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql1);
			int b = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql2);
			int c = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql3);
			int d = preparedStatement.executeUpdate();

			if (a == 0 && b == 0 && c == 0 && d == 0) {
				return false;
			}
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return false;
		}
		System.out.println("Record Successfully Updated");
		return true;
	}

	public ArrayList<RentalMemberBean> findAllPastMember() {
		Connection con = DBConnection.getConnection();
		ArrayList<RentalMemberBean> listUsers = new ArrayList<RentalMemberBean>();
		try {
			String sql = "select r.renter_name, r.dob, r.gender, r.mobile_no, r.aadhar_no, r.email_id, r.flat_maintenance, r.on_rent_date, r.leave_date, w.wing_name, f.flat_no from past_rentalmembers r inner join society_flats f on r.flat_id = f.flat_id inner join society_wings w on r.wing_id = w.wing_id order by leave_date";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RentalMemberBean rentalMemberBean = new RentalMemberBean();
				rentalMemberBean.setRenter_name(rs.getString("renter_name"));
				rentalMemberBean.setDob(rs.getString("dob"));
				rentalMemberBean.setGender(rs.getString("gender"));
				rentalMemberBean.setMobile_no(rs.getString("mobile_no"));
				rentalMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				rentalMemberBean.setEmail_id(rs.getString("email_id"));
				rentalMemberBean.setWing_name(rs.getString("wing_name"));
				rentalMemberBean.setFlat_no(rs.getInt("flat_no"));
				rentalMemberBean.setOn_rent_date(rs.getString("on_rent_date"));
				rentalMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));
				rentalMemberBean.setLeave_date(rs.getString("leave_date"));

				listUsers.add(rentalMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return listUsers;
	}
}

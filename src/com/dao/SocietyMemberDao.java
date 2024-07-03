package com.dao;

import java.sql.*;

import java.util.*;
import com.bean.SocietyMemberBean;
import com.util.DBConnection;

public class SocietyMemberDao {

	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public int insertMember(SocietyMemberBean societyMemberBean) throws SQLException {
		Connection con = DBConnection.getConnection();

		String select_sql = "SELECT * FROM society_flats where flat_id = ? and owner_name='Available';";
		String insert_sql = "INSERT INTO societymembers"
				+ "  (owner_name, gender, dob, mobile_no, aadhar_no, email_id, wing_id, flat_id, rental_status, flat_maintenance, buy_date) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String update_sql = "UPDATE society_flats set owner_name=?, maintenance=? balance_maintenance=? where flat_id = ?";

		int member_id = 0;

		try {
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement(select_sql);
			preparedStatement.setInt(1, societyMemberBean.getFlat_id());

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				preparedStatement = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setString(1, societyMemberBean.getOwner_name());
				preparedStatement.setString(2, societyMemberBean.getGender());
				preparedStatement.setString(3, societyMemberBean.getDob());
				preparedStatement.setString(4, societyMemberBean.getMobile_no());
				preparedStatement.setString(5, societyMemberBean.getAadhar_no());
				preparedStatement.setString(6, societyMemberBean.getEmail_id());
				preparedStatement.setInt(7, societyMemberBean.getWing_id());
				preparedStatement.setInt(8, societyMemberBean.getFlat_id());
				preparedStatement.setString(9, societyMemberBean.getRental_status());
				preparedStatement.setInt(10, societyMemberBean.getFlat_maintenance());
				preparedStatement.setString(11, societyMemberBean.getBuy_date());

				int x = preparedStatement.executeUpdate();
				if (x == 0)
					return 0;
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					member_id = generatedKeys.getInt(1);
				}
				preparedStatement = con.prepareStatement(update_sql);
				preparedStatement.setString(1, societyMemberBean.getOwner_name());
				preparedStatement.setInt(2, societyMemberBean.getFlat_maintenance());
				preparedStatement.setInt(3, societyMemberBean.getFlat_id());
				preparedStatement.executeUpdate();
			} else
				return 000;
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return 0;
		}
		System.out.println("Record Successfully Inserted");
		return member_id;
	}

	public SocietyMemberBean findMember(int flat_no) throws SQLException {
		Connection con = DBConnection.getConnection();
		SocietyMemberBean societyMemberBean = new SocietyMemberBean();
		try {
			String sql = "select m.member_id, m.owner_name, m.dob, m.gender, m.mobile_no, m.aadhar_no, m.email_id, m.rental_status, m.flat_maintenance, m.buy_date, w.wing_name, f.flat_no from societymembers m inner join society_flats f on m.flat_id = f.flat_id inner join society_wings w on m.wing_id = w.wing_id where f.flat_no = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, flat_no);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				societyMemberBean.setMember_id(rs.getInt("member_id"));
				societyMemberBean.setOwner_name(rs.getString("owner_name"));
				societyMemberBean.setDob(rs.getString("dob"));
				societyMemberBean.setGender(rs.getString("gender"));
				societyMemberBean.setMobile_no(rs.getString("mobile_no"));
				societyMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				societyMemberBean.setEmail_id(rs.getString("email_id"));
				societyMemberBean.setWing_name(rs.getString("wing_name"));
				societyMemberBean.setFlat_no(rs.getInt("flat_no"));
				societyMemberBean.setRental_status(rs.getString("rental_status"));
				societyMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));
				societyMemberBean.setBuy_date(rs.getString("buy_date"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Show Data." + sq);
		}
		return societyMemberBean;
	}

	public boolean update(SocietyMemberBean societyMemberBean) {
		Connection con = DBConnection.getConnection();
		String rental_status = societyMemberBean.getRental_status();
		String update_sql = "UPDATE societymembers set owner_name=?, gender=?, dob=?, mobile_no=?, aadhar_no=?, email_id=?, rental_status=?, flat_maintenance=?, buy_date=? where member_id = ?";
		String update1 = "UPDATE society_flats set maintenance=? where owner_name = ?";
//		String update2 = "UPDATE society_flats set maintenance=?, renter_name='Available' where owner_name = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(update_sql);

			preparedStatement.setString(1, societyMemberBean.getOwner_name());
			preparedStatement.setString(2, societyMemberBean.getGender());
			preparedStatement.setString(3, societyMemberBean.getDob());
			preparedStatement.setString(4, societyMemberBean.getMobile_no());
			preparedStatement.setString(5, societyMemberBean.getAadhar_no());
			preparedStatement.setString(6, societyMemberBean.getEmail_id());
			preparedStatement.setString(7, societyMemberBean.getRental_status());
			preparedStatement.setInt(8, societyMemberBean.getFlat_maintenance());
			preparedStatement.setString(9, societyMemberBean.getBuy_date());
			preparedStatement.setInt(10, societyMemberBean.getMember_id());

			int x = preparedStatement.executeUpdate();

//			if (rental_status.equals("Yes"))
			preparedStatement = con.prepareStatement(update1);
//			else if (rental_status.equals("No"))
//				preparedStatement = con.prepareStatement(update2);
			preparedStatement.setInt(1, societyMemberBean.getFlat_maintenance());
			preparedStatement.setString(2, societyMemberBean.getOwner_name());
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

	public boolean remove(String ownerName) {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "delete from societymembers where owner_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ownerName);
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

	public ArrayList<SocietyMemberBean> findAll() {
		Connection con = DBConnection.getConnection();
		ArrayList<SocietyMemberBean> listUsers = new ArrayList<SocietyMemberBean>();
		try {
			String sql = "select m.owner_name, m.dob, m.gender, m.mobile_no, m.aadhar_no, m.email_id, m.rental_status, m.flat_maintenance, m.buy_date, w.wing_name, f.flat_no from societymembers m inner join society_flats f on m.flat_id = f.flat_id inner join society_wings w on m.wing_id = w.wing_id;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SocietyMemberBean societyMemberBean = new SocietyMemberBean();
				societyMemberBean.setOwner_name(rs.getString("owner_name"));
				societyMemberBean.setDob(rs.getString("dob"));
				societyMemberBean.setGender(rs.getString("gender"));
				societyMemberBean.setMobile_no(rs.getString("mobile_no"));
				societyMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				societyMemberBean.setEmail_id(rs.getString("email_id"));
				societyMemberBean.setWing_name(rs.getString("wing_name"));
				societyMemberBean.setFlat_no(rs.getInt("flat_no"));
				societyMemberBean.setRental_status(rs.getString("rental_status"));
				societyMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));
				societyMemberBean.setBuy_date(rs.getString("buy_date"));

				listUsers.add(societyMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data From Society Members Table." + sq);
		}
		return listUsers;
	}

	public boolean pastMember(String owner_name, String sold_date) throws SQLException {
		Connection con = DBConnection.getConnection();
		try {
			String sql = "INSERT INTO past_societymembers (member_id,owner_name, gender, dob, mobile_no, aadhar_no, email_id, wing_id, flat_id, rental_status, flat_maintenance, buy_date)SELECT * FROM societymembers WHERE owner_name='"
					+ owner_name + "'";

			String sql1 = "update past_societymembers set sold_date = '" + sold_date + "' where owner_name = '"
					+ owner_name + "'";

			String sql2 = "update society_flats set owner_name = 'Available', maintenance = 0, balance_maintenance = 0 where owner_name = '"
					+ owner_name + "'";

			String sql3 = "delete from societymembers where owner_name ='" + owner_name + "'";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			int x = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql1);
			int y = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql2);
			int y1 = preparedStatement.executeUpdate();

			preparedStatement = con.prepareStatement(sql3);
			int z = preparedStatement.executeUpdate();

			if (x == 0 && y == 0 && y1 == 0 && z == 0) {
				return false;
			}
		} catch (SQLException sq) {
			System.out.println("Exception " + sq);
			return false;
		}
		System.out.println("Record Successfully Updated");
		return true;
	}

	public ArrayList<SocietyMemberBean> findAllPastMember() {
		Connection con = DBConnection.getConnection();
		ArrayList<SocietyMemberBean> listUsers = new ArrayList<SocietyMemberBean>();
		try {
			String sql1 = "select m.owner_name,m.dob, m.gender, m.mobile_no, m.aadhar_no, m.email_id, m.rental_status, m.flat_maintenance, m.buy_date, m.sold_date, w.wing_name, f.flat_no from past_societymembers m inner join society_flats f on m.flat_id = f.flat_id inner join society_wings w on w.wing_id = f.wing_id order by sold_date;";
			System.out.println(sql1);
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SocietyMemberBean societyMemberBean = new SocietyMemberBean();
				societyMemberBean.setOwner_name(rs.getString("owner_name"));
				societyMemberBean.setDob(rs.getString("dob"));
				societyMemberBean.setGender(rs.getString("gender"));
				societyMemberBean.setMobile_no(rs.getString("mobile_no"));
				societyMemberBean.setAadhar_no(rs.getString("aadhar_no"));
				societyMemberBean.setEmail_id(rs.getString("email_id"));
				societyMemberBean.setWing_name(rs.getString("wing_name"));
				societyMemberBean.setFlat_no(rs.getInt("flat_no"));
				societyMemberBean.setRental_status(rs.getString("rental_status"));
				societyMemberBean.setFlat_maintenance(rs.getInt("flat_maintenance"));
				societyMemberBean.setBuy_date(rs.getString("buy_date"));
				societyMemberBean.setSold_date(rs.getString("sold_date"));
				listUsers.add(societyMemberBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return listUsers;
	}
}

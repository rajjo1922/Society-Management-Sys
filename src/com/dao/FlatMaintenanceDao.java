package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.WingsFlatsBean;
import com.util.DBConnection;

public class FlatMaintenanceDao {

	public Boolean payMaintenance(int wing_id, int flat_id, int paid_amount, int bal_maintenance, String date) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement;
			String insert_sql = "INSERT INTO flat_maintenance(wing_id,flat_id,paid_amount,paid_date)VALUES (?,?,?,?);";
			preparedStatement = con.prepareStatement(insert_sql);
			preparedStatement.setInt(1, wing_id);
			preparedStatement.setInt(2, flat_id);
			preparedStatement.setInt(3, paid_amount);
			preparedStatement.setString(4, date);

			int x = preparedStatement.executeUpdate();
			if (x == 0)
				return false;
			else {
				String update_sql = "UPDATE society_flats set balance_maintenance=? where flat_id = ?";
				preparedStatement = con.prepareStatement(update_sql);
				preparedStatement.setInt(1, bal_maintenance);
				preparedStatement.setInt(2, flat_id);

				int y = preparedStatement.executeUpdate();
				if (y == 0)
					return false;
			}
		} catch (SQLException sq) {
			System.out.println("Exception :" + sq);
			return false;
		}
		System.out.println("Record Successfully Inserted");
		return true;
	}

	public Boolean addMonthlyMaintenance() {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement;
			String update_sql = "update society_flats set balance_maintenance = maintenance + balance_maintenance;";
			preparedStatement = con.prepareStatement(update_sql);

			int x = preparedStatement.executeUpdate();
			if (x == 0)
				return false;
		} catch (SQLException sq) {
			System.out.println("Exception :" + sq);
			return false;
		}
		System.out.println("Record Successfully Inserted");
		return true;
	}

	public ArrayList<WingsFlatsBean> viewMaintenance() {
		Connection con = DBConnection.getConnection();
		ArrayList<WingsFlatsBean> maintenanceList = new ArrayList<WingsFlatsBean>();
		try {
			String sql = "select f.flat_no,f.maintenance,f.balance_maintenance, w.wing_name from society_flats f inner join society_wings w on f.wing_id = w.wing_id;";			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setWing_name(rs.getString("wing_name"));
				wingsFlatsBean.setFlat_no(rs.getInt("flat_no"));
				wingsFlatsBean.setMaintenance(rs.getInt("maintenance"));
				wingsFlatsBean.setBalance_maintenance(rs.getInt("balance_maintenance"));
				maintenanceList.add(wingsFlatsBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return maintenanceList;
	}
	public ArrayList<WingsFlatsBean> viewPaidMaintenance() {
		Connection con = DBConnection.getConnection();
		ArrayList<WingsFlatsBean> maintenanceList = new ArrayList<WingsFlatsBean>();
		try {
			String sql = "select m.paid_amount, m.paid_date, f.flat_no, w.wing_name from flat_maintenance m inner join society_flats f on m.flat_id = f.flat_id inner join society_wings w on f.wing_id = w.wing_id;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setWing_name(rs.getString("wing_name"));
				wingsFlatsBean.setFlat_no(rs.getInt("flat_no"));
				wingsFlatsBean.setPaid_amount(rs.getInt("paid_amount"));
				wingsFlatsBean.setPaid_date(rs.getString("paid_date"));
				maintenanceList.add(wingsFlatsBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return maintenanceList;
	}
}

/*
SELECT (SELECT SUM(paid_amount) FROM flat_maintenance)-(SELECT SUM(expense_amount) FROM expenses) as balance; 
  */

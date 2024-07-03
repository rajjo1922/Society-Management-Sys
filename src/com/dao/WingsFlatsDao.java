package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import com.bean.WingsFlatsBean;
import com.util.DBConnection;

public class WingsFlatsDao {

	// *******************
	public ArrayList<WingsFlatsBean> getWing() {
		Connection con = DBConnection.getConnection();
		ArrayList<WingsFlatsBean> wingsList = new ArrayList<WingsFlatsBean>();
		try {
			String sql = "select * from society_wings";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setWing_id(rs.getInt("wing_id"));
				wingsFlatsBean.setWing_name(rs.getString("wing_name"));
				wingsList.add(wingsFlatsBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return wingsList;
	}

	// *******************
	public Boolean insertWing(String wing_name) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement;
			String sql = "select * from society_wings where wing_name ='" + wing_name + "';";
			preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next()) {
				String insert_sql = "INSERT INTO society_wings(wing_name)VALUES('" + wing_name + "')";
				preparedStatement = con.prepareStatement(insert_sql);
				int x = preparedStatement.executeUpdate();
				if (x == 0)
					return false;
			} else
				return false;
		} catch (SQLException sq) {
			return false;
		}
		System.out.println("Record Successfully Inserted");
		return true;
	}

	// *******************
	public Boolean insertFlat(int wing_groups, int flat_no) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement;
			String sql = "select * from society_flats where flat_no =" + flat_no + ";";
			preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next()) {
				String insert_sql = "INSERT INTO society_flats(wing_id,flat_no)VALUES(" + wing_groups + "," + flat_no
						+ ")";
				preparedStatement = con.prepareStatement(insert_sql);
				int x = preparedStatement.executeUpdate();
				if (x == 0)
					return false;
			} else
				return false;
		} catch (SQLException sq) {
			return false;
		}
		System.out.println("Record Successfully Inserted");
		return true;
	}

	// *******************
	public ArrayList<WingsFlatsBean> getFlatsByWing(int wing_id) {
		Connection con = DBConnection.getConnection();
//		JSONArray list = new JSONArray();
//		JSONObject obj1 = new JSONObject();
		ArrayList<WingsFlatsBean> flatsList = new ArrayList<WingsFlatsBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from society_flats where wing_id=" + wing_id + "");
			while (rs.next()) {
//				JSONObject obj = new JSONObject();
//				obj.put("flat_id", rs.getInt(1));
//				obj.put("wing_id", rs.getInt(2));
//				obj.put("flat_no", rs.getInt(3));

				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setFlat_id(rs.getInt("flat_id"));
				wingsFlatsBean.setFlat_no(rs.getInt("flat_no"));
				wingsFlatsBean.setWing_id(rs.getInt("wing_id"));

				flatsList.add(wingsFlatsBean);

				// list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flatsList;
	}

	public ArrayList<WingsFlatsBean> getFlatDetails() {
		Connection con = DBConnection.getConnection();
		ArrayList<WingsFlatsBean> flatsList = new ArrayList<WingsFlatsBean>();
		try {
			String sql = "SELECT a.wing_name,f.flat_id,f.flat_no, f.owner_name, f.renter_name FROM society_wings a inner join society_flats f where a.wing_id = f.wing_id;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setFlat_id(rs.getInt("flat_id"));
				wingsFlatsBean.setWing_name(rs.getString("wing_name"));
				wingsFlatsBean.setFlat_no(rs.getInt("flat_no"));
				wingsFlatsBean.setOwner_name(rs.getString("owner_name"));
				wingsFlatsBean.setRenter_name(rs.getString("renter_name"));
				flatsList.add(wingsFlatsBean);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data." + sq);
		}
		return flatsList;
	}

	public ArrayList<WingsFlatsBean> getFlatsMaintenance(int flat_id) {
		Connection con = DBConnection.getConnection();
		ArrayList<WingsFlatsBean> flatsList = new ArrayList<WingsFlatsBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from society_flats where flat_id=" + flat_id + "");
			while (rs.next()) {
				WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
				wingsFlatsBean.setMaintenance(rs.getInt("maintenance"));
				wingsFlatsBean.setBalance_maintenance(rs.getInt("balance_maintenance"));
				wingsFlatsBean.setFlat_id(rs.getInt("flat_id"));

				flatsList.add(wingsFlatsBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flatsList;
	}

	/*
	 * public ArrayList<WingsFlatsBean> findFlat() { Connection con =
	 * DBConnection.getConnection(); ArrayList<WingsFlatsBean> flatsList = new
	 * ArrayList<WingsFlatsBean>(); try { String sql =
	 * "SELECT a.wing_name,f.flat_id,f.flat_no FROM society_wings a inner join society_flats f where a.wing_id = f.wing_id"
	 * ; // String sql = "select * from society_flats"; PreparedStatement ps =
	 * con.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while
	 * (rs.next()) { WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
	 * wingsFlatsBean.setFlat_id(rs.getInt("flat_id")); //
	 * wingsFlatsBean.setWing_name(rs.getString("wing_name"));
	 * wingsFlatsBean.setFlat_no(rs.getInt("flat_no"));
	 * flatsList.add(wingsFlatsBean); } } catch (SQLException sq) {
	 * System.out.println("Unable to Fetch Data." + sq); } return flatsList; }
	 * 
	 * public HashMap<String, String> getWings() { Connection con =
	 * DBConnection.getConnection(); ArrayList<HashMap> list = new
	 * ArrayList<HashMap>(); HashMap wings = new HashMap(); String sql =
	 * "SELECT a.wing_id,a.wing_name FROM society_wings a "; PreparedStatement ps;
	 * try { ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while
	 * (rs.next()) {
	 * 
	 * WingsFlatsBean wingsFlatsBean = new WingsFlatsBean();
	 * wingsFlatsBean.setFlat_id(rs.getInt("flat_id"));
	 * wingsFlatsBean.setWing_name(rs.getString("wing_name"));
	 * wingsFlatsBean.setFlat_no(rs.getInt("flat_no")); list.add(wings);
	 * 
	 * } for (HashMap map : list) { wings.put(map.get("aId"), map.get("area")); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } System.out.println(wings);
	 * System.out.println(list); return wings; }
	 */

}
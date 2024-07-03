package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.ExpensesBean;
import com.util.DBConnection;

public class ExpensesDao {
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public int insertExpense(ExpensesBean expensesBean) throws SQLException {
		Connection con = DBConnection.getConnection();
		String insert_sql = "INSERT INTO expenses"
				+ "  (purpose, wing_id, flat_id, done_by, client_name, date, expense_amount) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?);";
		int expense_id = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, expensesBean.getPurpose());
			preparedStatement.setInt(2, expensesBean.getWing_id());
			preparedStatement.setInt(3, expensesBean.getFlat_id());
			preparedStatement.setString(4, expensesBean.getDone_by());
			preparedStatement.setString(5, expensesBean.getClient_name());
			preparedStatement.setString(6, expensesBean.getDate());
			preparedStatement.setInt(7, expensesBean.getExpense_amount());

			int x = preparedStatement.executeUpdate();
			if (x == 0) {
				return 0;
			}
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				expense_id = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		System.out.println("Record SuccessFully Added");
		return expense_id;
	}

	public ArrayList<ExpensesBean> viewall() {
		Connection con = DBConnection.getConnection();
		ArrayList<ExpensesBean> listUsers = new ArrayList<ExpensesBean>();
		try {
			String sql = "select e.expense_id, e.purpose, e.done_by, e.client_name, e.date, e.expense_amount, w.wing_name, f.flat_no from expenses e inner join society_flats f on e.flat_id = f.flat_id inner join society_wings w on e.wing_id = w.wing_id order by date";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesBean cb = new ExpensesBean();
				cb.setExpense_id(rs.getInt("expense_id"));
				cb.setPurpose(rs.getString("purpose"));
				cb.setWing_name(rs.getString("wing_name"));
				cb.setFlat_no(rs.getInt("flat_no"));
				cb.setDone_by(rs.getString("done_by"));
				cb.setClient_name(rs.getString("client_name"));
				cb.setDate(rs.getString("date"));
				cb.setExpense_amount(rs.getInt("expense_amount"));

				listUsers.add(cb);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to Fetch Data."+sq);
		}
		return listUsers;
	}
}

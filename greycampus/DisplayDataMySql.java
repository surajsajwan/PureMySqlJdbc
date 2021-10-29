package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DisplayDataMySql {
	public ArrayList<GetSet> display() {
		Connection connection = null;
		Statement createStatement = null;
		ArrayList<GetSet> al = new ArrayList<GetSet>();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee ", "root", "suraj");
			createStatement = connection.createStatement();
			ResultSet rs = createStatement.executeQuery("select * from emptbl");
			while (rs.next()) {
				GetSet gs = new GetSet();
				gs.setEno(rs.getInt("eno"));
				gs.setSalary(rs.getDouble("salary"));
				gs.setName(rs.getString("name"));
				al.add(gs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}

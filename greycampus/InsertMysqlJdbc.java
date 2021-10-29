package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMysqlJdbc {
	public void insert(GetSet gs) {
		Connection connection=null;
		PreparedStatement prepareStatement=null;
     try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee ", "root", "suraj");
		prepareStatement = connection.prepareStatement("insert into emptbl values(?,?,?)");
		prepareStatement.setInt(1,gs.getEno());
		prepareStatement.setDouble(2, gs.getSalary());
		prepareStatement.setString(3, gs.getName());
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.println("Inserted"+executeUpdate+"Values");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}

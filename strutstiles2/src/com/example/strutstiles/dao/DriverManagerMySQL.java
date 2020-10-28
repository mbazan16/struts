package com.example.strutstiles.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerMySQL {

	public static Connection getConexion() {
		String connectionString = "jdbc:mysql://localhost:3306/rrhh";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(connectionString, "prueba", "prueba");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * DriverManagerOracle dm = DriverManagerOracle.getInstancia(); Connection con =
	 * dm.getConexion();
	 * 
	 * System.out.println(con);
	 * 
	 * }
	 */

}

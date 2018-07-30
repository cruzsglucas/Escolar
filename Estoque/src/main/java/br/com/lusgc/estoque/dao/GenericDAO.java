package br.com.lusgc.estoque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {

	private Connection c;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName ="estoque";
		String user ="root";
		String senha ="";
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://"+hostName+":3306/"+dbName, user, senha);

		return c;
	}

}
package com.lusgc.escolar.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/escolar";
		private static final String USUARIO = "root";
		private static final String SENHA = "";
		
		public Connection criarConexao(){
			
			Connection conexao = null;
			
			try {
				
				Class.forName(DRIVER);
				conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
				
			} catch (Exception e) {
				System.out.println("Erro ao criar conexão com o banco: " + URL);
				e.printStackTrace();
			}
			return conexao;
		}
		
		
		public void fecharConexao(Connection conexao, PreparedStatement ps, ResultSet rs){
			
			try {
				
				if(conexao != null){
					conexao.close();
				}
				if(ps != null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
						
			} catch (Exception e) {
				System.out.println("Erro ao fechar conexão com o banco: " + URL);
			}
		}
	}
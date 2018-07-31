package com.lusgc.escolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lusgc.escolar.factory.ConnectionFactory;
import com.lusgc.escolar.model.Matricula;

public class NotasDAO extends ConnectionFactory {

	private static NotasDAO instance;


	public static NotasDAO getInstance(){
		if(instance == null)
			instance = new NotasDAO();
		return instance;
	}


	public List<Matricula> pesquisar(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = criarConexao();

		List<Matricula> listaMatriculas = new ArrayList<Matricula>();

		try {
			ps = con.prepareStatement("select * from matricula where id_aluno = ?");
			ps.setLong(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				
				Matricula matricula = new Matricula();
				
				matricula.setIdAluno(rs.getLong("id_aluno"));
				matricula.setIdDisciplina(rs.getLong("id_disciplina"));
				matricula.setNota1(rs.getInt("nota1"));
				matricula.setNota2(rs.getInt("nota2"));
				matricula.setNota3(rs.getInt("nota3"));
				matricula.setNota4(rs.getInt("nota4"));
				
				listaMatriculas.add(matricula);
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisar matricula: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

		return listaMatriculas;
	}

}
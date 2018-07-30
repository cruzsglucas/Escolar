package com.lusgc.escolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lusgc.escolar.factory.ConnectionFactory;
import com.lusgc.escolar.model.Aluno;

public class AlunoDAO extends ConnectionFactory {

	private static AlunoDAO instance;


	public static AlunoDAO getInstance(){
		if(instance == null)
			instance = new AlunoDAO();
		return instance;
	}

	public ArrayList<Aluno> listarTodos(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Aluno> alunos = null;

		con = criarConexao();
		alunos = new ArrayList<Aluno>();
		try {
			ps = con.prepareStatement("select * from aluno order by nome");
			rs = ps.executeQuery();

			while(rs.next()){
				Aluno aluno = new Aluno();

				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRa(rs.getString("ra"));

				alunos.add(aluno);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os alunos: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}
		return alunos;
	}

	public void excluir(Long id) {
		Connection con = criarConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "delete from aluno where id = ?";
			ps = con.prepareStatement(sql);

			System.out.println(sql);
			ps.setLong(1, id);
			ps.execute();

		}catch(Exception e ) {
			System.out.println("Erro ao excluir o aluno: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

	}

	public Aluno pesquisar(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = criarConexao();

		Aluno aluno = new Aluno();

		try {
			ps = con.prepareStatement("select * from aluno where id = ?");
			ps.setLong(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRa(rs.getString("ra"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisar aluno: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

		return aluno;
	}

	public void incluir(Aluno aluno) {
		PreparedStatement ps = null;
		Connection con = criarConexao();
		ResultSet rs = null;

		try {
			String sql = "insert into aluno (nome, ra, cpf) values (?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getRa());
			ps.setString(3, aluno.getCpf());

			ps.execute();

		}
		catch(Exception e) {

		} finally {
			fecharConexao(con, ps, rs);
		}

	}

	public void alterar(Aluno aluno) {
		PreparedStatement ps = null;
		Connection con = criarConexao();
		ResultSet rs = null;

		try {

			String sql = "update aluno set nome = ?, cpf = ?, ra = ? where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getRa());
			ps.setLong(4, aluno.getId());
			
			ps.execute();

		} catch(Exception e) {
			System.out.println("Não foi possível atualizar o aluno: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

	}	
}
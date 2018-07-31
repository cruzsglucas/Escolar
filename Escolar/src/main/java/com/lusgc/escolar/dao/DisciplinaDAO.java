package com.lusgc.escolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lusgc.escolar.factory.ConnectionFactory;
import com.lusgc.escolar.model.Disciplina;

public class DisciplinaDAO extends ConnectionFactory {

	private static DisciplinaDAO instance;


	public static DisciplinaDAO getInstance(){
		if(instance == null)
			instance = new DisciplinaDAO();
		return instance;
	}

	public ArrayList<Disciplina> listarTodos(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Disciplina> disciplinas = null;

		con = criarConexao();
		disciplinas = new ArrayList<Disciplina>();
		try {
			ps = con.prepareStatement("select * from disciplina order by descricao");
			rs = ps.executeQuery();

			while(rs.next()){
				Disciplina disciplina = new Disciplina();

				disciplina.setId(rs.getLong("id"));
				disciplina.setDescricao(rs.getString("descricao"));

				disciplinas.add(disciplina);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todas as disciplinas: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}
		return disciplinas;
	}

	public void excluir(Long id) {
		Connection con = criarConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "delete from disciplina where id = ?";
			ps = con.prepareStatement(sql);

			System.out.println(sql);
			ps.setLong(1, id);
			ps.execute();

		}catch(Exception e ) {
			System.out.println("Erro ao excluir o disciplina: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

	}

	public Disciplina pesquisar(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = criarConexao();

		Disciplina disciplina = new Disciplina();

		try {
			ps = con.prepareStatement("select * from disciplina where id = ?");
			ps.setLong(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				disciplina.setId(rs.getLong("id"));
				disciplina.setDescricao(rs.getString("descricao"));
			}

		} catch (Exception e) {
			System.out.println("Erro ao pesquisar disciplina: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

		return disciplina;
	}

	public void incluir(Disciplina disciplina) {
		PreparedStatement ps = null;
		Connection con = criarConexao();
		ResultSet rs = null;

		try {
			String sql = "insert into disciplina (descricao) values (?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, disciplina.getDescricao());

			ps.execute();

		}
		catch(Exception e) {

		} finally {
			fecharConexao(con, ps, rs);
		}

	}

	public void alterar(Disciplina disciplina) {
		PreparedStatement ps = null;
		Connection con = criarConexao();
		ResultSet rs = null;

		try {

			String sql = "update disciplina set descricao = ? where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, disciplina.getDescricao());
			ps.setLong(2, disciplina.getId());
			
			ps.execute();

		} catch(Exception e) {
			System.out.println("Não foi possível atualizar a disciplina: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(con, ps, rs);
		}

	}	
}
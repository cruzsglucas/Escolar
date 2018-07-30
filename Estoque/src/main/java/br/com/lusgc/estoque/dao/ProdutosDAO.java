package br.com.lusgc.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lusgc.estoque.model.Produto;

public class ProdutosDAO {

	private Connection con;
	
	public ProdutosDAO() throws ClassNotFoundException, SQLException {
		GenericDAO genericDAO = new GenericDAO();
		con = genericDAO.getConnection();
	}
	
	public List<Produto> getProdutos() throws SQLException{
		String sql = "select * from produtos";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		while (rs.next()) {
			Produto produto = new Produto();
			produto.setId(rs.getLong("1"));
			produto.setDescricao(rs.getString("2"));
			produto.setMarca(rs.getString("3"));
			produto.setPreco(rs.getFloat("4"));
			
			produtos.add(produto);
		}

		this.con.close();
		
		return produtos;
	}
	
	public Produto getProduto() {
		return new Produto();
	}

	public void setProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (descricao, marca, preco) VALUES (?, ?, ?)";
		PreparedStatement ps = this.con.prepareStatement(sql);ps.setString(1, "");
		
		ps.setString(1, produto.getDescricao());
		ps.setString(2, produto.getMarca());
		ps.setFloat(3, produto.getPreco());
		
		ps.execute();

		System.out.println("Executado setProduto()");
		
		this.con.close();
	}
	
	public void updateProduto(Produto produto) throws SQLException {
		String sql = "UPDATE produto SET descricao = ?, marca = ?, preco = ? WHERE id = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, produto.getDescricao());
		ps.setString(2, produto.getMarca());
		ps.setFloat(3, produto.getPreco());
		ps.setLong(4, produto.getId());

		ps.execute();
		
		this.con.close();
	}
	
	public void deleteProduto(Produto produto) throws SQLException {
		String sql = "DELETE FROM produto WHERE id = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setLong(1, produto.getId());
		ps.execute();
		
		this.con.close();
	}
	
}
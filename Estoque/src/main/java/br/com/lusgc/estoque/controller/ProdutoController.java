package br.com.lusgc.estoque.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lusgc.estoque.dao.ProdutosDAO;
import br.com.lusgc.estoque.model.Produto;

public class ProdutoController {

	private ProdutosDAO produtosDAO;
	
	public ProdutoController() throws ClassNotFoundException, SQLException {
		this.produtosDAO = new ProdutosDAO();
	}
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			produtos = this.produtosDAO.getProdutos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}
}

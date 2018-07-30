package br.com.lusgc.estoque.main;

import java.sql.SQLException;

import br.com.lusgc.estoque.dao.ProdutosDAO;
import br.com.lusgc.estoque.model.Produto;
import br.com.lusgc.estoque.resource.ProdutoResource;

public class LancaProdutos {

	public static void main(String[] args) {	
		Produto produto = new Produto();
		
		produto.setDescricao("Biscoito rechedo sabor morango 200g");
		produto.setMarca("Gulosos");
		produto.setPreco(1.60f);
		
		try {
			ProdutoResource produtoResource = new ProdutoResource();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
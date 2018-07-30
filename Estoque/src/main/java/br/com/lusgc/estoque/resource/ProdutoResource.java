package br.com.lusgc.estoque.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.lusgc.estoque.dao.ProdutosDAO;
import br.com.lusgc.estoque.model.Produto;

@Path("/produtos")
public class ProdutoResource {

	private ProdutosDAO produtosDAO;

	public ProdutoResource() throws ClassNotFoundException, SQLException {
		this.produtosDAO = new ProdutosDAO();
	}

	@GET
	@Path("/getProdutos")
	@Produces("application/json")
	public List<Produto> getProdutos() throws SQLException{
		return this.produtosDAO.getProdutos();
	}
	
	//@POST
	//@Path("/salvarProduto")
	//public void postProduto(Produto produto) throws SQLException {
	//	this.produtosDAO.setProduto(produto);
	//}
}
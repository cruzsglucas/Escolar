$(document).ready( function(){
	$('#btn-salvar').click(function(){
		
		//var descricao = $('#descricao').val();
		//var marca = $('#valor').val();
		//var preco = $('#preco').val();
		
		//var xhr = new XMLHttpRequest();
		xhr.open('POST', 'http://localhost:8080/Estoque/ProdutoServlet');
		xhr.send();
	});
});
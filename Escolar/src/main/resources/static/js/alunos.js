$(document).ready(function(){

	$('#btn_salvar').click(function(){

		var nome = $('#nome').val();
		var ra = $('#ra').val();
		var cpf = $('#cpf').val();

		var aluno = {'nome' : nome, 'ra': ra, 'cpf': cpf};

		$.ajax({
			url : 'http://localhost:8080/escola/alunos',
			type: 'POST',
			contentType : 'application/json',
			data: JSON.stringify(aluno)
		});
	});
	
	$('#btn_pesquisar').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/alunos/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function(data){
				$('#nome').val(data.nome);
				$('#cpf').val(data.cpf);
				$('#ra').val(data.ra);
			}
		});
		
	});
	
	$('#btn_pesquisar').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/alunos/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function(data){
				$('#nome').val(data.nome);
				$('#cpf').val(data.cpf);
				$('#ra').val(data.ra);
			}
		});
		
	});
	
	$('#btn_alterar').click(function(){
		var id = $('#id').val();
		var nome = $('#nome').val();
		var cpf = $('#cpf').val();
		var ra = $('#ra').val();
		
		var aluno = {'id' : id, 'nome' : nome, 'cpf' : cpf, 'ra' : ra};
		
		$.ajax({
			url: 'http://localhost:8080/escola/alunos',
			type: 'PUT',
			contentType: 'application/json',
			data : JSON.stringify(aluno),
			success : function(){
				alert('Alterado com sucesso.');
			}
		});
	});
	
	$('#btn_remover').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/alunos/' + id,
			type: 'DELETE',
			contentType: 'application/json',
			success : function(){
				alert('Removido com sucesso.');
			}
		});
	});
	
	$.ajax({
		url: 'http://localhost:8080/escola/alunos',
		type: 'GET',
		contentType: 'application/json',
		success: function(data){
			
			$('#tabela_alunos').append(
					'<thead>' +
						'<tr>' +
							'<th>NOME</td>'+
							'<th>CPF</td>'+
							'<th>RA</td>'+
						'</tr>' +
					'</thead>'
			);
			
			for (var i = 0; i < data.length; i++) {
				$('#tabela_alunos').append(
				'<tr>' +
				'<td>' + data[i].nome + '</td>' +
				'<td>' + data[i].cpf + '</td>' +
				'<td>' + data[i].ra + '</td>' +
				'</tr>'		
				);
			}
		}
		
	});
});
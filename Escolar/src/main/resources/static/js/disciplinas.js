$(document).ready(function(){

	$('#btn_salvar').click(function(){

		var descricao = $('#descricao').val();
		var ra = $('#ra').val();
		var cpf = $('#cpf').val();

		var descricao = {'descricao' : descricao, 'ra': ra, 'cpf': cpf};

		$.ajax({
			url : 'http://localhost:8080/escola/disciplinas',
			type: 'POST',
			contentType : 'application/json',
			data: JSON.stringify(descricao)
		});
	});
	
	$('#btn_pesquisar').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/disciplinas/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function(data){
				$('#descricao').val(data.descricao);
			}
		});
		
	});
	
	$('#btn_pesquisar').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/disciplinas/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function(data){
				$('#descricao').val(data.descricao);
			}
		});
		
	});
	
	$('#btn_alterar').click(function(){
		var id = $('#id').val();
		var descricao = $('#descricao').val();
		var cpf = $('#cpf').val();
		var ra = $('#ra').val();
		
		var descricao = {'id' : id, 'descricao' : descricao, 'cpf' : cpf, 'ra' : ra};
		
		$.ajax({
			url: 'http://localhost:8080/escola/disciplinas',
			type: 'PUT',
			contentType: 'application/json',
			data : JSON.stringify(descricao),
			success : function(){
				alert('Alterado com sucesso.');
			}
		});
	});
	
	$('#btn_remover').click(function(){
		var id = $('#id').val();
		
		$.ajax({
			url: 'http://localhost:8080/escola/disciplinas/' + id,
			type: 'DELETE',
			contentType: 'application/json',
			success : function(){
				alert('Removido com sucesso.');
			}
		});
	});
	
	$.ajax({
		url: 'http://localhost:8080/escola/disciplinas',
		type: 'GET',
		contentType: 'application/json',
		success: function(data){
			
			$('#tabela_disciplinas').append(
					'<thead>' +
						'<tr>' +
							'<th></th>' +
							'<th>DISCIPLINA</td>'+
						'</tr>' +
					'</thead>'
			);
			
			for (var i = 0; i < data.length; i++) {
				$('#tabela_disciplinas').append(
				'<tr>' +
				'<td>#' + data[i].id + '</td>' +
				'<td>' + data[i].descricao + '</td>' +
				'</tr>'		
				);
			}
		}
		
	});
});
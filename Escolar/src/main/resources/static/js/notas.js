$(document).ready(function(){
	
	$('#btn_mostrar_notas').click(function(){
		var id = $('#id_aluno').val();
		
		$.ajax({
			url : 'http://localhost:8080/escola/notas/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function(data){
				
				$('#tabela_notas').append(
						'<thead>' +
							'<tr>'+
							'<th># DISCIPLINA</th>' +
							'<th>NOTA 1</th>' +
							'<th>NOTA 2</th>' +
							'<th>NOTA 3</th>' +
							'<th>NOTA 4</th>' +
							'</tr>' +
						'</thead>'
				);
				
				for (var i = 0; i < data.length; i++){
					
					$('#tabela_notas').append(
							'<tr>' +
								'<td>' +data[i].idDisciplina + '</td>' +
								'<td>' +data[i].nota1 + '</td>' +
								'<td>' +data[i].nota2 + '</td>' +
								'<td>' +data[i].nota3 + '</td>' +
								'<td>' +data[i].nota4 + '</td>' +
							'</tr>'
					);
				}
			}
		});
	});
});
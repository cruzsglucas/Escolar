package com.lusgc.escolar.resource;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lusgc.escolar.controller.AlunoController;
import com.lusgc.escolar.model.Aluno;

@RequestMapping("/escola")
@RestController
public class AlunoResource {

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ArrayList<Aluno> listarTodos(){
		return new AlunoController().listarTodos();
	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.GET)
	public Aluno pesquisar(@PathVariable("id") Long id){

		return new AlunoController().pesquisar(id);
	}

	@RequestMapping(value = "/alunos", method = RequestMethod.POST)
	public void addReservation(@RequestBody Aluno aluno) {
		new AlunoController().incluir(aluno);
	}

	@RequestMapping(value = "/alunos", method = RequestMethod.PUT)
	public void alterar(@RequestBody Aluno aluno){
		new AlunoController().alterar(aluno);
	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable ("id") Long id) {
		new AlunoController().remover(id);
	}
}
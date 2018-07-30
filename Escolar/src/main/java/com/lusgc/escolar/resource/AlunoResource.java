package com.lusgc.escolar.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lusgc.escolar.model.Aluno;
import com.lusgc.gestaoescolar.controller.AlunoController;

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
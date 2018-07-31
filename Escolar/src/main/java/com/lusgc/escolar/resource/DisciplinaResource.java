package com.lusgc.escolar.resource;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lusgc.escolar.controller.DisciplinaController;
import com.lusgc.escolar.model.Disciplina;

@RequestMapping("/escola")
@RestController
public class DisciplinaResource {

	@RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
	public ArrayList<Disciplina> listarTodos(){
		return new DisciplinaController().listarTodos();
	}

	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.GET)
	public Disciplina pesquisar(@PathVariable("id") Long id){

		return new DisciplinaController().pesquisar(id);
	}

	@RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
	public void addReservation(@RequestBody Disciplina disciplina) {
		new DisciplinaController().incluir(disciplina);
	}

	@RequestMapping(value = "/disciplinas", method = RequestMethod.PUT)
	public void alterar(@RequestBody Disciplina disciplina){
		new DisciplinaController().alterar(disciplina);
	}

	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable ("id") Long id) {
		new DisciplinaController().remover(id);
	}
}
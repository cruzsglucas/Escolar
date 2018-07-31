package com.lusgc.escolar.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lusgc.escolar.controller.MatriculaController;
import com.lusgc.escolar.model.Matricula;

@RequestMapping(value="/escola")
@RestController
public class MatriculaResource {

	@RequestMapping(value = "/notas/{id}", method = RequestMethod.GET)
	public List<Matricula> pesquisar(@PathVariable("id") Long id){

		return new MatriculaController().pesquisar(id);
	}

}

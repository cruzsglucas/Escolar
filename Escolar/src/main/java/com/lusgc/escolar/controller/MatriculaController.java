package com.lusgc.escolar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lusgc.escolar.dao.NotasDAO;
import com.lusgc.escolar.model.Matricula;

@Controller
public class MatriculaController {

	@GetMapping("/Notas")
	public ModelAndView mostrarNotas() {
		return new ModelAndView("Notas");
	}
	
	public List<Matricula> pesquisar(Long idAluno) {
		return NotasDAO.getInstance().pesquisar(idAluno);
	}

}

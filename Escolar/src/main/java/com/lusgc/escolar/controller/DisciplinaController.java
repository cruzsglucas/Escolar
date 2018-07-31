package com.lusgc.escolar.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lusgc.escolar.dao.DisciplinaDAO;
import com.lusgc.escolar.model.Disciplina;

@Controller
public class DisciplinaController {

	public ArrayList<Disciplina> listarTodos(){
		return DisciplinaDAO.getInstance().listarTodos();
	}

	public void remover(Long id) {
		DisciplinaDAO.getInstance().excluir(id);
	}

	public Disciplina pesquisar(Long id) {
		return DisciplinaDAO.getInstance().pesquisar(id);
	}

	public void incluir(Disciplina Disciplina) {
		DisciplinaDAO.getInstance().incluir(Disciplina);
	}

	public void alterar(Disciplina Disciplina) {
		DisciplinaDAO.getInstance().alterar(Disciplina); 		
	}

	@GetMapping("/listarDisciplinas")
	public ModelAndView listarDisciplinas() {
		ModelAndView modelAndView = new ModelAndView("ListaDisciplinas");

		return modelAndView;
	}
	

}

package com.lusgc.escolar.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lusgc.escolar.dao.AlunoDAO;
import com.lusgc.escolar.model.Aluno;

@Controller
public class AlunoController {

	public ArrayList<Aluno> listarTodos(){
		return AlunoDAO.getInstance().listarTodos();
	}

	public void remover(Long id) {
		AlunoDAO.getInstance().excluir(id);
	}

	public Aluno pesquisar(Long id) {
		return AlunoDAO.getInstance().pesquisar(id);
	}

	public void incluir(Aluno Aluno) {
		AlunoDAO.getInstance().incluir(Aluno);
	}

	public void alterar(Aluno Aluno) {
		AlunoDAO.getInstance().alterar(Aluno); 		
	}

	@GetMapping("/alunos")
	public ModelAndView adicionarAliuno() {
		ModelAndView modelAndView = new ModelAndView("Alunos");
		return modelAndView;
	}
	
	@GetMapping("/listarAlunos")
	public ModelAndView listarAlunos() {
		ModelAndView modelAndView = new ModelAndView("ListaAlunos");
		return modelAndView;
	}
	

}

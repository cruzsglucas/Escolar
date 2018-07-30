package com.lusgc.gestaoescolar.controller;

import java.util.ArrayList;

import com.lusgc.escolar.dao.AlunoDAO;
import com.lusgc.escolar.model.Aluno;

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
	
}

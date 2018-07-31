package com.lusgc.escolar.model;

public class Matricula {

	private Long idAluno;
	private Long idDisciplina;
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	
	public Matricula() {
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

	public int getNota4() {
		return nota4;
	}

	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result + ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
		result = prime * result + nota1;
		result = prime * result + nota2;
		result = prime * result + nota3;
		result = prime * result + nota4;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		if (nota1 != other.nota1)
			return false;
		if (nota2 != other.nota2)
			return false;
		if (nota3 != other.nota3)
			return false;
		if (nota4 != other.nota4)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [idAluno=" + idAluno + ", idDisciplina=" + idDisciplina + ", nota1=" + nota1 + ", nota2="
				+ nota2 + ", nota3=" + nota3 + ", nota4=" + nota4 + "]";
	}
	
	
}

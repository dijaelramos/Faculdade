package br.edu.uninassau.salas;

public class Alunos {
	// nome, data de nascimento, CPF e matricula
		
	private String matricula;
	private String cpf;
	private String nome;
	private String dtnascimento;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

}	
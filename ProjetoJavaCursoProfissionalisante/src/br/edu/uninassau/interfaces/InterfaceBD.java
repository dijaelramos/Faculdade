package br.edu.uninassau.interfaces;

import java.util.ArrayList;

import br.edu.uninassau.salas.Alunos;

public interface InterfaceBD {
	
	//Interfaces para o Usuário visualizar atravez da minha classe "AlunosBD"
	public boolean salvar (Alunos aluno) throws Exception;
	public boolean editar (Alunos aluno) throws Exception;
	public boolean apagar (Alunos aluno) throws Exception;
	public ArrayList <Alunos> listar() throws Exception; 
}

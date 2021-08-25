package br.edu.uninassau.menutestes;

import br.edu.uninassau.bancodedados.AlunoBD;
import br.edu.uninassau.salas.Alunos;

public class MenuEditar {

	public static void main(String[] args) {
		
		Alunos aluno = new Alunos();
		aluno.setMatricula("14");
		aluno.setCpf("8888");
		aluno.setNome("Lemos Dijael ");
		aluno.setDtnascimento("202345");
		
		//Comando para editar os alunos acima
		AlunoBD bd = new AlunoBD ();
		bd.editar(aluno);
				
		
	}

}
package br.edu.uninassau.menutestes;

import br.edu.uninassau.bancodedados.AlunoBD;
import br.edu.uninassau.salas.Alunos;

public class MenuCadastro {

	public static void main(String[] args) {

		Alunos aluno = new Alunos();
		aluno.setMatricula("14");
		aluno.setCpf("12871152");
		aluno.setNome("Dijael Lemos");
		aluno.setDtnascimento("200220");
		
		//Comando para salvar os alunos acima
		AlunoBD bd = new AlunoBD();
		bd.salvar(aluno);
                
	}
}
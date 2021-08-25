package br.edu.uninassau.menutestes;

import br.edu.uninassau.conexaobanco.ConexaoMySQL;

public class MenuPrincipal_Banco {

	public static void main(String[] args) {
			
            ConexaoMySQL conn = new ConexaoMySQL();
            
		System.out.println(ConexaoMySQL.statusConection()); //Serve para saber se estar conectado ou não
		ConexaoMySQL.getConexaoMySQL(); // Serve para fazer a conexão do Banco
		System.out.println(ConexaoMySQL.statusConection()); //Serve para saber se estar conectado ou não
		ConexaoMySQL.FecharConexao(); // Vai fechar a conexão com o Banco
               
	}
}
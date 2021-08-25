package br.edu.uninassau.bancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.edu.uninassau.conexaobanco.ConexaoMySQL;
import br.edu.uninassau.interfaces.InterfaceBD;
import br.edu.uninassau.salas.Alunos;

public class AlunoBD implements InterfaceBD { 

    public int size;
// Implements para se conectar com a minha InterfaceBD

        @Override
	public boolean salvar(Alunos aluno) {
            
            Connection conn = ConexaoMySQL.getConexaoMySQL();
		

		String sql = "INSERT INTO alunos ( matricula, cpf, nome, dtnascimento) VALUES ( ?, ?, ?, ? )";

// ***************** Tratamentos de erros *****************
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
																				// o BD
			// número é lugar que deve ficar no BD para poder jogar lá
			ps.setString(1, aluno.getMatricula());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getNome());
			ps.setString(4, aluno.getDtnascimento());

// ***************** Executando a ação de cima **********************************
			ps.execute();

			System.out.println("===== ELEMENTOS CADASTRADOS! =====");
			return true;

		} catch (SQLException e) {

			System.out.println("===== ERRO AO CADASTRAR! =====");
                    // Joga na tela todos os erros da execução
		} 
		return false;

	}

	@Override
	public boolean editar(Alunos aluno) {

		ConexaoMySQL conn = (ConexaoMySQL) ConexaoMySQL.getConexaoMySQL();

		boolean isFirstField = true;

		StringBuilder sql = new StringBuilder(); // Essas duas linhas servem para que as alterações sejam feitas
													// individualmente
		sql.append("UPDADE Alunos SET");
		if (aluno.getCpf() != null) {
			sql.append(" cpf = ? ");
			isFirstField = false;
		}
		if (aluno.getNome() != null) {
			sql.append(" nome = ? ");
			isFirstField = false;
		}
		if (aluno.getDtnascimento() != null) {
			sql.append(" data de nascimento = ? ");
			isFirstField = false;
		}
		sql.append("WHERE matricula = ? ");

		try {
			PreparedStatement ps = ((Connection) conn).prepareStatement(sql.toString());

			int cont = 1;
			if (aluno.getCpf() != null) {
				ps.setString(cont++, aluno.getCpf());
			}
			if (aluno.getNome() != null) {
				ps.setNString(cont++, aluno.getNome());
			}
			if (aluno.getDtnascimento() != null) {
				ps.setString(cont++, aluno.getDtnascimento());
			}
			ps.setString(cont, aluno.getMatricula());

			ps.execute();

			System.out.println("===== ATUALIZADO COM SUCESSO! =====");
			return true;

		} catch (SQLException e) {
			System.out.println("===== ERRO AO ATUALIZAR! =====");
		} finally {
			ConexaoMySQL.FecharConexao();
		}
		return false;
	}

	@Override
	public boolean apagar(Alunos aluno) throws Exception {

		ConexaoMySQL conn = (ConexaoMySQL) ConexaoMySQL.getConexaoMySQL(); // Estabelecer a conexão com o BD

		String sql = "DELETE FROM Alunos WHERE matricula = ?";
		try {
			PreparedStatement ps = ((Connection) conn).prepareStatement(sql); // Prepara a ordem que vai ser mandar para
																				// o BD

			ps.setString(1, aluno.getMatricula()); // número é lugar que deve ficar no BD para poder jogar lá

// ***************** Executando a ação de cima **********************************
			ps.execute();

			System.out.println("===== ELEMENTOS DELETADOS COM SUCESSO! =====");
			return true;

		} catch (SQLException e) {
			throw e; // Serve para jogar o resultado de erro para a tela de execução MenuDeletar

		} finally {
			ConexaoMySQL.FecharConexao(); // Fechar a conexão com o BD
		}
	}

	@Override
	public ArrayList<Alunos> listar() throws Exception {
		Connection conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Alunos> listar = new ArrayList<>();

		String sql = "SELECT * FROM Alunos ORDENAR BY NOME"; // Listar todos os alunos, caso for listar algué
																// específico, usar o WHERE depois do Alunos

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); // Vai chamar todos os resultados para dentro do ps indo para o BD
		while (rs.next()) {
			Alunos a = new Alunos();
			a.setMatricula(rs.getString("matricula")); // verificar isso no BD para poder retornar a Lista, para saber
														// se é uma String mesmo
			a.setCpf(rs.getString("cpf"));
			a.setNome(rs.getString("nome"));
			a.setDtnascimento(rs.getString("Data de Nascimento"));

			listar.add(a);
		}

		return listar;
	}

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
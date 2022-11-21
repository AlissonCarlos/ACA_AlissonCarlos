package br.atos.dao;

import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.atos.fabricaConexao.Conexao;
import br.atos.model.Usuario;

public class UsuarioDAO {
	
	public boolean validaLogin(Usuario usuario) {
		boolean validacao = false;
		
		Connection conexao = null;
		conexao = Conexao.criarConexaocomMySql();
		
		String sql = "select * from login where username = ? and password = ?";
		
		PreparedStatement pStatement;
		
		
		try {
			pStatement = conexao.prepareStatement(sql);
			pStatement.setString(1, usuario.getNome());
			pStatement.setString(2,usuario.getSenha());
			
			ResultSet result = pStatement.executeQuery();
			
			validacao = result.next();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu ruim no metodo validaLogin!!!");
		}
		return validacao;
		
	}

	public boolean salvarUsuario(Usuario usuario) throws ServerException {
		boolean sucesso;
		
		Connection conexao = null;
		conexao = Conexao.criarConexaocomMySql();
		
		String sql = "INSERT INTO bmydx53hvaupquiupsev.login (username, password) values (?, ?)";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			
			pstm.execute();
			sucesso = true;
			
		} catch (Exception e) {
			e.getCause();
			sucesso = false;
		}
		return sucesso;
		
	}

}

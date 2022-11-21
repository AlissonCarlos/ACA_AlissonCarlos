package br.atos.dataBase;

import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import br.atos.conexao.Conexao;
import br.atos.model.EntidadeLogin;

public class LoginDAO {
	
	public boolean validaLogin(EntidadeLogin loginEntidade ) {
		boolean validacao = false;
		
		Connection conexao = null;
		conexao = Conexao.criarConexaocomMySql();
		
		String sql = "select * from login where username = ? and password = ?";
		
		PreparedStatement pStatement;
		
		
		try {
			pStatement = conexao.prepareStatement(sql);
			pStatement.setString(1, loginEntidade.getUsername());
			pStatement.setString(2,loginEntidade.getPassword());
			
			
			ResultSet result = pStatement.executeQuery();
			
			validacao = result.next();
	
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu ruim no metodo validaLogin!!!");
			
		}
		
		return validacao;
		
	}

	public boolean salvarUsuario(EntidadeLogin login) throws ServerException {
		boolean sucesso;
		
		Connection conexao = null;
		conexao = Conexao.criarConexaocomMySql();
		
		String sql = "INSERT INTO bmydx53hvaupquiupsev.login (username, password) values (?, ?)";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, login.getUsername());
			pstm.setString(2, login.getPassword());
			
			pstm.execute();
			sucesso = true;
			
		} catch (Exception e) {
			e.getCause();
			sucesso = false;
		}
		return sucesso;
		
	}

}

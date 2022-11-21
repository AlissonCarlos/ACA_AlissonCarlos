package br.atos.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static String dbUrl = "jdbc:mysql://bmydx53hvaupquiupsev-mysql.services.clever-cloud.com:3306/bmydx53hvaupquiupsev?useTimezone=true&serverTimezone=UTC";
	private static String dbUser = "uqzu3xu8qtpu9ow7";
	private static String dbPassword = "bReyByaXdqL3vCMVuyue";
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	
	public static Connection criarConexaocomMySql() {
	
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			
			 if (conexao != null) {
	             System.out.println("Conectado");
	         }
			 else {
				 System.out.println("Erro na conexão!! ");
			 }
			 return conexao;
		}catch (Exception e) {
			e.getCause();
		}
		return conexao;
	}
}

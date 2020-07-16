package br.com.minhaCasaTech.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	Connection con = null;
	final String url = "jdbc:mariadb://localhost:3306/minha_casa_tech";
	final String usuario ="poo_20203";
	final String senha = "melhormateria";
	
	public  Connection getCon() {
		if(con == null) {
			try {
				con = DriverManager.getConnection(url, usuario, senha);
			}catch(SQLException e){
				e.printStackTrace();
			}
			return con;
		} else {
			return con;
		}
	}
	
	public  void closeCon() {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

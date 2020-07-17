package br.com.minhaCasaTech.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	
	Connection con = null;
	final String url = "jdbc:mariadb://localhost:3306/minha_casa_tech";
	final String usuario ="poo_20203";
	final String senha = "melhormateria";
	
	public Connection getCon() {
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
	
	public void closeCon() {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public abstract void cadastrar(VO entity) throws SQLException;
	
	public abstract void editar(VO entity) throws SQLException;
	
	public abstract ResultSet buscarPorId(VO entity) throws SQLException;
	
	public abstract ResultSet buscarPorId(long id) throws SQLException;
	
	public abstract ResultSet listar() throws SQLException;
	
	public abstract void deletar(VO entity) throws SQLException;
}

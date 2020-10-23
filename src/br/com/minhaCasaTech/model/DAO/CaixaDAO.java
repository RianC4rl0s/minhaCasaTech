package br.com.minhaCasaTech.model.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CaixaDAO {
	
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
	public ResultSet pegarCaixa() {
		String sql = "select valor from caixa where id = 1";
		Statement st;
		ResultSet rs =null;
		
		try {
			st =getCon().createStatement();
			rs = st.executeQuery(sql);
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	public void attValor(double valor) {
		System.out.println("O novo valor: " + valor);
		String sql = "update caixa set valor = ? where id = 1";
		try {
			PreparedStatement pst =getCon().prepareStatement(sql);
			pst.setDouble(1, valor);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

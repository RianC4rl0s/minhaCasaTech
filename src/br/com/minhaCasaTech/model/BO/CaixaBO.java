package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.minhaCasaTech.model.DAO.CaixaDAO;



public class CaixaBO {
	
	public void addValor(Double valor) {
		double valorO = pegarValor();
		valorO = valorO + valor;
		CaixaDAO cdao = new CaixaDAO();
		cdao.attValor(valorO);
	}
	public void subValor(Double valor) {
		double valorO = pegarValor();
		valorO = valorO - valor;
		CaixaDAO cdao = new CaixaDAO();
		cdao.attValor(valorO);
	}
	
	public double pegarValor() {
		double valor = 0;
		ResultSet rs = null;
		CaixaDAO cdao = new CaixaDAO();
		rs = cdao.pegarCaixa();
		try {
			valor = rs.getDouble("valor");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}
}

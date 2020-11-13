package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.minhaCasaTech.model.DAO.CaixaDAO;
import br.com.minhaCasaTech.model.VO.CaixaVO;



public class CaixaBO {
	
	public void addValor(Double valor) {
		double valorO = pegarValor().getValor();
		valorO = valorO + valor;
		System.out.println(valorO);
		CaixaDAO cdao = new CaixaDAO();
		cdao.attValor(valorO);
		System.out.println(valorO);
	}
	public void subValor(Double valor) {
		double valorO = pegarValor().getValor();
		valorO = valorO - valor;
		System.out.println(valorO);
		CaixaDAO cdao = new CaixaDAO();
		cdao.attValor(valorO);
		System.out.println(valorO);
	}
	
	public CaixaVO pegarValor() {
		CaixaVO caixa = new CaixaVO();
		
		ResultSet rs = null;
		CaixaDAO cdao = new CaixaDAO();
		rs = cdao.pegarCaixa();
		try {
			rs.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			caixa.setValor( rs.getDouble("valor"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caixa;
	}
	public void alterarValor(Double valor) {
		CaixaDAO cdao = new CaixaDAO();
		cdao.attValor(valor);
	}
}

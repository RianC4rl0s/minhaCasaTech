package br.com.minhaCasaTech.controller;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.DAO.*;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import exception.NotFoundException;

public class Principal {
	public static void main(String args[]) throws SQLException {
		
	    System.out.println("================");

	    // DAOS
		LocalDAO d1 = new LocalDAO();
		EquipamentoDAO d2 = new EquipamentoDAO();
		ClienteDAO d3 = new ClienteDAO();
		FuncionarioDAO d4 = new FuncionarioDAO();
		ProprietarioDAO d5 = new ProprietarioDAO();
		CompraDAO d6 = new CompraDAO();
		VendaDAO d7 = new VendaDAO();
		
		// BOS
		CompraBO b1 = new CompraBO();
		VendaBO v1 = new VendaBO();
		
		// Gerando Relatório
		Calendar dI = Calendar.getInstance();
		dI.set(2020,06,19);
		Calendar dF = Calendar.getInstance();
		dF.set(2020,07,19);
		
		try {
			System.out.println(v1.gerarRelatorio(dI,dF));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ResultSet rs = d6.gerarRelatorio(dI, dF, 1);
		while (rs.next())
		{
			System.out.println(rs.getLong("id"));
		}*/
		
		//ResultSet locais = dao2.buscar();

	}
}

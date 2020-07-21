package br.com.minhaCasaTech.controller;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.DAO.*;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import exception.NotFoundException;

public class Principal {
	/*public static void main(String args[]) throws SQLException {
		
	    System.out.println("================");

<<<<<<< HEAD
		LocalDAO d1 = new LocalDAO();
		EquipamentoDAO d2 = new EquipamentoDAO();
		ClienteDAO d3 = new ClienteDAO();
		FuncionarioDAO d4 = new FuncionarioDAO();
		ProprietarioDAO d5 = new ProprietarioDAO();
		CompraDAO d6 = new CompraDAO();
		VendaDAO d7 = new VendaDAO();
		
		CompraVO c = new CompraVO(1000, 333.20, 10);
		FuncionarioVO f1 = new FuncionarioVO("Junior", "Angicos", "84999488501", "junior", "seNha123");
		LocalVO local2  = new LocalVO("joaozin", "b-3 prateleira:4");
		EquipamentoVO eqp = new EquipamentoVO("Mouse", 333.30, 1000, 10, 10002, f1, local2);
		eqp.setId_equipamento(new Long(1));
		c.addEquipamento(eqp);
		
		
		//System.out.println(c.getData());
		//System.out.println(c.getEquipamentos());
		//d6.cadastrar(c);
		Calendar dI = Calendar.getInstance();
		dI.set(2020,06,17);
		Calendar dF = Calendar.getInstance();
		dF.set(2020,07,17);
		
		
		ResultSet rs = d6.gerarRelatorio(dI, dF, 1);
		while (rs.next())
		{
			System.out.println(rs.getLong("id"));
		}
		
		//d1.cadastrar(local2);
		//d4.cadastrar(f1);
		
		//ResultSet locais = dao2.buscar();

	}*/
}

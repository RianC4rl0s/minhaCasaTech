package br.com.minhaCasaTech.controller;



import br.com.minhaCasaTech.model.DAO.*;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.LocalVO;

public class Principal {
	public static void main(String args[]) {
		
	    System.out.println("================");

		LocalDAO d1 = new LocalDAO();
		EquipamentoDAO d2 = new EquipamentoDAO();
		ClienteDAO d3 = new ClienteDAO();
		FuncionarioDAO d4 = new FuncionarioDAO();
		ProprietarioDAO d5 = new ProprietarioDAO();
		
		LocalVO local2  = new LocalVO("joaozin", "b-3 prateleira:4");
		FuncionarioVO f1 = new FuncionarioVO("Junior", "Angicos", "84999488501", "junior", "seNha123");
		
		d1.cadastrar(local2);
		d4.cadastrar(f1);
		
		//ResultSet locais = dao2.buscar();

	}
}

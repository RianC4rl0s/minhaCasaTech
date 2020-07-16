package br.com.minhaCasaTech.controller;


import java.util.List;

import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.VO.LocalVO;

public class Principal {
	public static void main(String args[]) {
		
	    System.out.println("================");

		LocalDAO dao2 = new LocalDAO();
		
		LocalVO local2  = new LocalVO("joaozin", "b-3 prateleira:4");
		
		dao2.cadastrar(local2);
		
		List<LocalVO> locais = dao2.listar();
		
		for (LocalVO l: locais) {
			System.out.println(l.toString());
		}
	       System.out.println("================");

	}
}

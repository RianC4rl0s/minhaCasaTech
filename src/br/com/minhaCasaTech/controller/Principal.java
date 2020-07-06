package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import java.util.Scanner;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.Local;
import br.com.minhaCasaTech.model.VO.Responsavel;

public class Principal {

	public static void main(String[] args) {
		 String nome;
		 double peso;
		 double preco;
		 int quantidade;
		 int numeroDeSerie;
		 Responsavel responsavel = new Responsavel("Joao","Rua 12","3420");
		 
		 Local local = new Local("Centro","Prateleira A-23");
		 System.out.println(responsavel.toString());
		 System.out.println(local.toString());
		Scanner t = new Scanner(System.in);
		
		System.out.println("Digite o nome");
		nome = t.nextLine();
		System.out.println("Digite o peso");
		peso = t.nextDouble();
		t.nextLine();
		System.out.println("Digite o preço");
		preco = t.nextDouble();
		t.nextLine();
		System.out.println("Digite a quantidade");
		quantidade = t.nextInt();
		t.nextLine();
		System.out.println("Digite o numero de serie");
		numeroDeSerie = t.nextInt();
		t.nextLine();
		t.close();
		EquipamentoVO eqpVo = new EquipamentoVO(nome, peso, preco, quantidade, numeroDeSerie, responsavel, local);
		EquipamentoBO eqpBo = new EquipamentoBO();
		
		eqpBo.cadastrar(eqpVo);
		
	}

}

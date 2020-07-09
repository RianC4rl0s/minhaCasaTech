package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import java.util.Scanner;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.Responsavel;

public class Principal {

	public static void main(String[] args) {
		 String nome;
		 double peso;
		 double preco;
		 int quantidade;
		 int numeroDeSerie;
		 Responsavel responsavel = new Responsavel("Joao","Rua 12","3420");
		 
		 LocalVO local = new LocalVO("Centro","Prateleira A-23");
		 System.out.println(responsavel.toString());
		 System.out.println(local.toString());
		
		 Scanner t = new Scanner(System.in);
		System.out.println("\n\n=====CADASTRO=====\n");
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
		
		System.out.println("\n\n=====LISTA=====\n");
		EquipamentoVO lista[] = new EquipamentoVO[3];
		
		lista = eqpBo.listar();
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Equipamento n°: " + i+1 + "\n");
			System.out.println(lista[i].toString());
			
		}
		
		System.out.println("\n\n =====BUSCAR===== \n");
	    EquipamentoVO e = new EquipamentoVO();
	    e = eqpBo.buscar(eqpVo);
	    System.out.println("\n" + e.toString());

		System.out.println("\n\n =====Editar===== \n");
	    EquipamentoVO f = new EquipamentoVO();
	    f = eqpBo.editar(eqpVo);
	    System.out.println("\n" + f.toString());
	}

}

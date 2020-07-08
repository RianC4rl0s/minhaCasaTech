package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.PessoaVO;

public class PessoaBO {
	public void cadastrar(PessoaVO pessoa) {
		
		System.out.println(pessoa.toString());
		
	}
	public PessoaVO editar(PessoaVO pessoa) {
		pessoa.setNome("Novo nome");
		pessoa.setEndereco("Novo endereco");
		
		return pessoa;
	}
	public PessoaVO[] buscar() {
		PessoaVO a = new PessoaVO("Joao","Casa 3");
		PessoaVO b = new PessoaVO("Maria","Casa 1");
		PessoaVO c = new PessoaVO("Claudio","Casa 2");
		
		PessoaVO pessoa[] = new PessoaVO[3];
		
		pessoa[0] = a;
		pessoa[1] = b;
		pessoa[2]= c;
		
		return pessoa;
	}
	public PessoaVO buscar (PessoaVO pessoa) {
		
		return pessoa;
	}
	public void deletar(PessoaVO pessoa) {
		pessoa.setNome("Deletado");
		pessoa.setEndereco("DEletado");
		System.out.println("Deletado");
	}
}

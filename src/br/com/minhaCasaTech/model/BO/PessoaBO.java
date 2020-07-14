package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.PessoaVO;

public class PessoaBO implements PessoaInterBO{
	
	public void cadastrar(PessoaVO pessoa) {
		if (pessoa != null)
			System.out.println("Responsável adicionado:\n=================="+pessoa.toString());
		else
			System.out.println("Responsável nulo!");
	}
	
	public PessoaVO editar(PessoaVO pessoa) {
		pessoa.setNome("Novo nome");
		pessoa.setEndereco("Novo endereco");
		
		return pessoa;
	}
	
	public PessoaVO[] listar() {
		//PessoaVO a = new("Joao","Casa 3");
		//PessoaVO b = new PessoaVO("Maria","Casa 1");
		//PessoaVO c = new PessoaVO("Claudio","Casa 2");
		
		PessoaVO pessoa[] = null;
		
	
	return pessoa;
	}
	
	public PessoaVO buscar (PessoaVO pessoa) {
		return pessoa;
	}
	
	public void deletar(PessoaVO pessoa) {
		System.out.println("Deletado");
	}
}

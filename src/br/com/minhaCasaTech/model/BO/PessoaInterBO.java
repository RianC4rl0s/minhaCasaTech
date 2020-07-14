package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.PessoaVO;

public interface PessoaInterBO {
	public void cadastrar(PessoaVO pessoa);
	
	public PessoaVO editar(PessoaVO pessoa);
	
	public PessoaVO buscar (PessoaVO pessoa);
	
	public PessoaVO[] listar() ;
	
	public void deletar(PessoaVO pessoa) ;
}

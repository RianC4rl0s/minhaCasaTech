package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.PessoaVO;

public interface PessoaInterDAO {
	public void cadastrar(PessoaVO pessoa);
	
	public PessoaVO editar(PessoaVO pessoa);
	
	public PessoaVO buscar (PessoaVO pessoa);
	
	public PessoaVO[] buscar() ;
	
	public void deletar(PessoaVO pessoa) ;
}

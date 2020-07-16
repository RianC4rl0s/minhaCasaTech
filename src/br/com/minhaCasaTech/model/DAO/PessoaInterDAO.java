package br.com.minhaCasaTech.model.DAO;

import java.sql.ResultSet;

public interface PessoaInterDAO<VO> {
	public void cadastrar(VO pessoa);
	
	public void editar(VO pessoa);
	
	public ResultSet buscarPorId(Long id);
	
	public ResultSet buscar() ;
	
	public void deletar(VO pessoa) ;
}

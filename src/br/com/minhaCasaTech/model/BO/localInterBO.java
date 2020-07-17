package br.com.minhaCasaTech.model.BO;


import java.sql.ResultSet;
import java.util.List;

import br.com.minhaCasaTech.model.VO.LocalVO;

public interface localInterBO {
	public void cadastrar(LocalVO local);
	
	public LocalVO editar(LocalVO local);
	
	public LocalVO buscarPorId(ResultSet rs);
	
	public LocalVO buscarPorId(LocalVO local);
	
	public List<LocalVO> listar();
	
	public void deletar(LocalVO local);
}

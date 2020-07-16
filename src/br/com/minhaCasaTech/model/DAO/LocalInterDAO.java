package br.com.minhaCasaTech.model.DAO;

import java.util.List;

import br.com.minhaCasaTech.model.VO.LocalVO;

public interface LocalInterDAO<VO> {
    public void cadastrar(VO local);
	
	public LocalVO editar(VO local);
	
	public LocalVO buscar(VO local);
	
	//public LocalVO[] listar();
	
	public LocalVO buscarPorId(Long id);
	
	public List<LocalVO> listar();
	
	public void deletar(VO local);
}

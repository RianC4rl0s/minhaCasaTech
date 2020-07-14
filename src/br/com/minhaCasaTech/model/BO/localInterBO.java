package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.LocalVO;

public interface localInterBO {
	public void cadastrar(LocalVO local);
	
	public LocalVO editar(LocalVO local);
	
	public LocalVO buscar(LocalVO local);
	
	public LocalVO[] buscar();
	
	public void deletar(LocalVO local);
}

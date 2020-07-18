package br.com.minhaCasaTech.model.BO;

import java.util.List;

import exception.InsertException;
import exception.NotFoundException;

public interface BaseInterBO <VO>{
	public void cadastrar(VO vo) throws InsertException;
	public VO buscarPorId(Long id) throws NotFoundException;
	public VO buscarPorId(VO vo) throws NotFoundException;
	public List<VO> listar() throws NotFoundException;
	public void editar(VO vo) throws InsertException;
	public void deletar(VO vo) throws InsertException;
}

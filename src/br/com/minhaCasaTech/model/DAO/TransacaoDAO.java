package br.com.minhaCasaTech.model.DAO;

import java.util.Calendar;

import br.com.minhaCasaTech.model.VO.TransacaoVO;

public class TransacaoDAO {
	
	public void cadastar(TransacaoVO transacao) {
		
	}
	
	public void editar(TransacaoVO transacao) {
		
	}
	
	public void deletar(TransacaoVO transacao) {
		
	}

	public TransacaoVO buscar(TransacaoVO transacao) {
		return transacao;
	}

	public TransacaoVO[] buscar() {
		TransacaoVO[] transacoes = null;
		return transacoes;
	}

	public TransacaoVO[] gerarRelatorio(Calendar dataInicio, Calendar dataFim, int tipo) {
		TransacaoVO transacoes[] = null;
		return transacoes;
	}
}

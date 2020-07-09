package br.com.minhaCasaTech.model.BO;

import java.util.Calendar;
import java.util.TimeZone;

import br.com.minhaCasaTech.model.VO.TransacaoVO;

public class TransacaoBO {
	
	public void cadastar(TransacaoVO transacao) {
		if (transacao != null)
			System.out.println("Transação adicionada:\n=================="+transacao.toString());
		else
			System.out.println("Responsável nulo!");
	}
	
	public void editar(TransacaoVO transacao) {
		// EDITAR
	}
	
	public void deletar(TransacaoVO transacao) {
		System.out.println("Deletada");
	}

	public TransacaoVO buscar(TransacaoVO transacao) {
		return transacao;
	}

	public TransacaoVO[] listar(TransacaoVO transacao) {
		TransacaoVO a = new TransacaoVO(1200,300,3);
		TransacaoVO b = new TransacaoVO(5200,340,4);
		TransacaoVO c = new TransacaoVO(4444,450,6);
		
		TransacaoVO transacoes[] = new TransacaoVO[3];
		
		transacoes[0] = a;
		transacoes[1] = b;
		transacoes[2]= c;
		
		return transacoes;
	}

	public TransacaoVO[] gerarRelatorio(Calendar dataInicio, Calendar dataFim, int tipo) {
		TransacaoVO transacoes[] = null;
		TimeZone zone = TimeZone.getTimeZone("GMT-3:00");
		
		if (dataInicio.after(dataFim))
			System.out.println("Data de início depois da data fim");
		else if (dataInicio.after(Calendar.getInstance(zone)))
			System.out.println("Data de início inválida");
		else
			if (tipo == 0)
				//VENDAS
				;
			else
				//COMPRAS
				;
		
		return transacoes;
	}
}

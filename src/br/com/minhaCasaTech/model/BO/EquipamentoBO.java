package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.EquipamentoDAO;
import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;


public class EquipamentoBO implements EquipamentoInterBO{
	
	public void cadastrar(EquipamentoVO equipamento) {
		if (equipamento != null)
		{
			System.out.println("Equipamento adicionado:\n==================\n"+equipamento);
		}else
			System.out.println("Equipamento nulo!");		
	}
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		eqpOrigem.setNome("NOVO NOME");
		eqpOrigem.setQuantidade(1);
				
		return eqpOrigem;
	}
	
	public void deletar(EquipamentoVO equipamento) {
		System.out.println("Deletado");
	}
	
	public EquipamentoVO buscar(EquipamentoVO e) {
		return e;
	}
	
	public List<EquipamentoVO> listar(){
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listar();
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			while(rs.next()) {
				EquipamentoVO eqp = new EquipamentoVO();	
				eqp.setId_equipamento(rs.getLong("id"));
				eqp.setNome(rs.getString("nome"));
				eqp.setPeso(rs.getDouble("peso"));
				eqp.setPreco(rs.getDouble("preco"));
				eqp.setQuantidade(rs.getInt("quantidade"));
				eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				
				LocalVO l = new LocalVO();
				LocalBO lbo = new LocalBO();
				LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId(ldao.buscarPorId(rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa s� q com responsavel
				/*
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelDAO rdao = new ResponsavelDAO();
				r = rdao.buscarId(rs.getLong("id_responsavel"));	
				eqp.setResponsavel(r);
				*/
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	
	public EquipamentoVO buscarPorNome(String nome) {
		
		EquipamentoVO eqp = null;
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorNS(int ns) {
		
		EquipamentoVO eqp =  null;
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorLocal(LocalVO local) {
	
		EquipamentoVO eqp = null;
		
		return eqp;
	}
	
	public ResponsavelVO adicionnarResponsavel(ResponsavelVO responsael) {
		ResponsavelVO rep =null;
		return rep;
	}
	
	public LocalVO adicionarLocal(LocalVO local) {
		LocalVO lo = null;
		return lo;
	}
}

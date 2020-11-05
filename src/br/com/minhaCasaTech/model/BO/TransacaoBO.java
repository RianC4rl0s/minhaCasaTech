package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.TransacaoDAO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import exception.InsertException;
import exception.NotFoundException;

public class TransacaoBO implements BaseInterBO<TransacaoVO>{
	
	static private TransacaoDAO<TransacaoVO> dao0 = new TransacaoDAO<TransacaoVO>();

	@Override
	public void cadastrar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
	}

	@Override
	public TransacaoVO buscarPorId(Long id) throws NotFoundException {
		ResultSet rs;
		try {
			rs = dao0.buscarPorId(id);
			return this.montarTransacao(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public TransacaoVO buscarPorId(TransacaoVO vo) throws NotFoundException {
		ResultSet rs = dao0.buscarPorId(vo);		
		return this.montarTransacao(rs);
	}

	@Override
	public List<TransacaoVO> listar() throws NotFoundException{
		// TODO Auto-generated method stub		
		try {
			ResultSet rs = dao0.listar();
			List<TransacaoVO> transacoes = new ArrayList<>();
			System.out.println(rs);
	
			while (rs.next()) {
				TransacaoVO generic = new TransacaoVO();
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				transacoes.add(generic);
			}
			
			return transacoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}
	
	
	public TransacaoVO montarTransacao(ResultSet rs) {
		TransacaoVO generic = new TransacaoVO();
		try {
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				return generic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}	
	
}

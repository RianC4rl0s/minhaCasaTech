package br.com.minhaCasaTech.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.BO.BaseInterBO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import exception.InsertException;
import exception.NotFoundException;

public class CompraBO implements BaseInterBO<CompraVO> {
	static private CompraDAO dao0 = new CompraDAO();
	
	@Override
	public void cadastrar(CompraVO vo) throws InsertException {
		// TODO Auto-generated method stub
		try {
			if (vo == null) {
				throw new InsertException("Impossível cadastrar, transação nula");
			}
			else{
				dao0.cadastrar(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	@Override
	public CompraVO buscarPorId(Long id) throws NotFoundException {
		try {
			if (id < 0)
				throw new NotFoundException();
			else {
				ResultSet rs = dao0.buscarPorId(id);
				CompraVO generic = new CompraVO();
				while(rs.next()) {
					Calendar data = Calendar.getInstance();
					generic.setId_transacao(rs.getLong("id"));
					generic.setValorTotal(rs.getDouble("valor_total"));
					generic.setPesoTotal(rs.getDouble("peso_total"));
					generic.setTotalEquip(rs.getInt("total_equip"));
					data.setTime(rs.getDate("data"));
					generic.setData(data);
					generic.setTipo(rs.getInt("tipo"));
				}
				return generic;
			}
		} catch (SQLException e){
			throw new NotFoundException();
		}
	}

	@Override
	public CompraVO buscarPorId(CompraVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = dao0.buscarPorId(vo);
			CompraVO generic = new CompraVO();
			
			while(rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
			}
			
			return generic;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public List<CompraVO> listar() throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = dao0.listar();
			ArrayList<CompraVO> compras = new ArrayList<CompraVO>();
			CompraVO generic = new CompraVO();
			
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
			}
			
			return compras;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public void editar(CompraVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(CompraVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}
	
	public List<CompraVO> gerarRelatorio(Calendar dataInicio, Calendar dataFim) throws NotFoundException{
		try {
			ResultSet rs = dao0.gerarRelatorio(dataInicio, dataFim, 1);
			ArrayList<CompraVO> compras = new ArrayList<CompraVO>();
			CompraVO generic = new CompraVO();
			
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
			}
			
			return compras;
		}catch (SQLException e) {
			throw new NotFoundException();
		}
	}
}

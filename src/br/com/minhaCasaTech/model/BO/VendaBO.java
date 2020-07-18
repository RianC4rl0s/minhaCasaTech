package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.ClienteDAO;
import br.com.minhaCasaTech.model.DAO.VendaDAO;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import exception.InsertException;
import exception.NotFoundException;

public class VendaBO implements BaseInterBO<VendaVO> {
	static private VendaDAO dao0 = new VendaDAO();
	static private ClienteDAO dao1 = new ClienteDAO();
	
	@Override
	public void cadastrar(VendaVO vo) throws InsertException {
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
	public VendaVO buscarPorId(Long id) throws NotFoundException {
		try {
			if (id < 0)
				throw new NotFoundException();
			else {
				ResultSet rs = dao0.buscarPorId(id);
				VendaVO generic = new VendaVO();
				while(rs.next()) {
					Calendar data = Calendar.getInstance();
					generic.setId_transacao(rs.getLong("id"));
					generic.setValorTotal(rs.getDouble("valor_total"));
					generic.setPesoTotal(rs.getDouble("peso_total"));
					generic.setTotalEquip(rs.getInt("total_equip"));
					data.setTime(rs.getDate("data"));
					generic.setData(data);
					generic.setTipo(rs.getInt("tipo"));
					
					ClienteVO c = new ClienteVO();
					c.setId_cliente(rs.getLong("id_cliente"));
					ResultSet rs2 = dao1.buscarPorId(c.getId_cliente());
					c.setCpf(rs2.getString("cpf"));
					c.setId_pessoa(rs2.getLong("id_pessoa"));
					ResultSet rs3 = dao1.buscarPorId(c);
					c.setNome(rs3.getString("nome"));
					c.setEndereco(rs3.getString("endereco"));
					
					generic.setCliente(c);
				}
				return generic;
			}
		} catch (SQLException e){
			throw new NotFoundException();
		}
	}

	@Override
	public VendaVO buscarPorId(VendaVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = dao0.buscarPorId(vo);
			VendaVO generic = new VendaVO();
			
			while(rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				
				ClienteVO c = new ClienteVO();
				c.setId_cliente(rs.getLong("id_cliente"));
				ResultSet rs2 = dao1.buscarPorId(c.getId_cliente());
				c.setCpf(rs2.getString("cpf"));
				c.setId_pessoa(rs2.getLong("id_pessoa"));
				ResultSet rs3 = dao1.buscarPorId(c);
				c.setNome(rs3.getString("nome"));
				c.setEndereco(rs3.getString("endereco"));
				
				generic.setCliente(c);
			}
			
			return generic;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public List<VendaVO> listar() throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = dao0.listar();
			ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
			VendaVO generic = new VendaVO();
			
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				
				ClienteVO c = new ClienteVO();
				c.setId_cliente(rs.getLong("id_cliente"));
				ResultSet rs2 = dao1.buscarPorId(c.getId_cliente());
				c.setCpf(rs2.getString("cpf"));
				c.setId_pessoa(rs2.getLong("id_pessoa"));
				ResultSet rs3 = dao1.buscarPorId(c);
				c.setNome(rs3.getString("nome"));
				c.setEndereco(rs3.getString("endereco"));
				
				generic.setCliente(c);
			}
			
			return vendas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public void editar(VendaVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(VendaVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}
	
	public List<VendaVO> gerarRelatorio(Calendar dataInicio, Calendar dataFim) throws NotFoundException{
		try {
			ResultSet rs = dao0.gerarRelatorio(dataInicio, dataFim, 2);
			ArrayList<VendaVO> vendas = new ArrayList<VendaVO>();
			VendaVO generic = new VendaVO();
			
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				
				ResultSet rs1 = dao0.buscarPorId(generic.getId_venda());
				ClienteVO c = new ClienteVO();
				c.setId_cliente(rs1.getLong("id_cliente"));
				ResultSet rs2 = dao1.buscarPorId(c.getId_cliente());
				c.setCpf(rs2.getString("cpf"));
				c.setId_pessoa(rs2.getLong("id_pessoa"));
				ResultSet rs3 = dao1.buscarPorId(c);
				c.setNome(rs3.getString("nome"));
				c.setEndereco(rs3.getString("endereco"));
				
				generic.setCliente(c);
			}
			
			return vendas;
		}catch (SQLException e) {
			throw new NotFoundException();
		}
	}

}

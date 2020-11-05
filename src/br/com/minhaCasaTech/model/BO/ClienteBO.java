package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.ClienteDAO;
import br.com.minhaCasaTech.model.DAO.FuncionarioDAO;
import br.com.minhaCasaTech.model.DAO.ProprietarioDAO;
import br.com.minhaCasaTech.model.DAO.ResponsavelDAO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import exception.InsertException;
import exception.NotFoundException;

public class ClienteBO implements BaseInterBO<ClienteVO>{
	static private ClienteDAO dao0 = new ClienteDAO();

	@Override
	public void cadastrar(ClienteVO vo) throws InsertException {
		try {
			if (this.buscarPorCpf(vo.getCpf()) != null) {
					dao0.cadastrar(vo);
			}					
		} catch (NotFoundException e) {
			throw new InsertException("Usuário já existe");
		}
	}

	@Override
	public ClienteVO buscarPorId(Long id) throws NotFoundException {
		ResultSet rs =  dao0.buscarPorId(id);
		try {
			ClienteVO generic = new ClienteVO();
			while(rs.next()) {
				generic.setId_pessoa(rs.getLong("cliente.id_pessoa"));
				generic.setId_cliente(rs.getLong("cliente.id"));
				generic.setCpf(rs.getString("cpf"));
					
				ResultSet rs1 = dao0.buscarPorId(generic);
				rs1.next();
				
				generic.setNome(rs1.getString("nome"));
				generic.setEndereco(rs1.getString("endereco"));
				return generic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClienteVO buscarPorId(ClienteVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ClienteVO buscarPorCpf(String cpf) throws NotFoundException {
		ResultSet rs = dao0.buscarPorCpf(cpf);
		
		try {
			ClienteVO generic = new ClienteVO();
			while(rs.next()) {
				generic.setId_pessoa(rs.getLong("cliente.id_pessoa"));
				generic.setId_cliente(rs.getLong("cliente.id"));
				generic.setCpf(rs.getString("cpf"));
					
				ResultSet rs1 = dao0.buscarPorId(generic);
				rs1.next();
				
				generic.setNome(rs1.getString("nome"));
				generic.setEndereco(rs1.getString("endereco"));
				return generic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClienteVO> listar() {
		ResultSet rs = dao0.listar();
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		
		try {
			while(rs.next()) {
				clientes.add(montarCliente(rs));
			}
			return (List<ClienteVO>) clientes;
		} catch (SQLException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void editar(ClienteVO vo) throws InsertException {
		try {
			if (this.buscarPorCpf(vo.getCpf()) != null)
				dao0.editar(vo);
		} catch (NotFoundException e) {
			throw new InsertException("Usuário não existe");
		}
		
	}

	@Override
	public void deletar(ClienteVO vo) throws InsertException {
		try {
			
			if (this.buscarPorCpf(vo.getCpf()) != null) {
				ResultSet rs = dao0.buscarPorId(vo);
				try {
					rs.next();
					vo.setId_cliente(rs.getLong("cliente.id"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao0.deletar(vo);
			}
		} catch (NotFoundException e) {
			throw new InsertException("Usuário não existe");
		}
		
	}
	
	public ClienteVO montarCliente(ResultSet rs) throws NotFoundException{
		ClienteVO generic = new ClienteVO();
		try {
			generic.setId_pessoa(rs.getLong("cliente.id_pessoa"));
			generic.setId_cliente(rs.getLong("cliente.id"));
			generic.setCpf(rs.getString("cpf"));
			
			ResultSet rs1 = dao0.buscarPorId(generic);
			rs1.next();
			
			generic.setNome(rs1.getString("nome"));
			generic.setEndereco(rs1.getString("endereco"));
			return generic;	
		} catch (SQLException e) {
			throw new NotFoundException();
		}
	}

}

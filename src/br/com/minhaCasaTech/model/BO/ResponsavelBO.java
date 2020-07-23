package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.FuncionarioDAO;
import br.com.minhaCasaTech.model.DAO.ProprietarioDAO;
import br.com.minhaCasaTech.model.DAO.ResponsavelDAO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import exception.InsertException;
import exception.NotFoundException;

public class ResponsavelBO<VO extends ResponsavelVO> implements BaseInterBO<VO>{
	static private ResponsavelDAO dao0 = new ResponsavelDAO();
	static private ProprietarioDAO dao1 = new ProprietarioDAO();
	static private FuncionarioDAO dao2 = new FuncionarioDAO();

	@Override
	public void cadastrar(VO vo) throws InsertException {
		try {
			if (this.buscarPorLogin(vo) == null)
				if (vo instanceof ProprietarioVO)
					dao1.cadastrar((ProprietarioVO) vo);
				else
					dao2.cadastrar((FuncionarioVO) vo);
		} catch (NotFoundException e) {
			throw new InsertException("Usuário já existe");
		}
	}

	@Override
	public VO buscarPorId(Long id) throws NotFoundException {
		ResultSet rs =  dao0.buscarPorId(id);
		try {
			ResponsavelVO generic = new ResponsavelVO();
			while(rs.next()) {
				generic.setId_pessoa(rs.getLong("responsavel.id_pessoa"));
				generic.setId_responsavel(rs.getLong("responsavel.id"));
				generic.setTelefone(rs.getString("telefone"));
				generic.setLogin(rs.getString("login"));
				generic.setSenha(rs.getString("senha"));
					
				ResultSet rs1 = dao0.buscarPorId(generic);
				rs1.next();
				
				generic.setNome(rs1.getString("nome"));
				generic.setEndereco(rs1.getString("endereco"));
				return (VO) generic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponsavelVO buscarPorId(ResponsavelVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResponsavelVO buscarPorLogin(ResponsavelVO vo) throws NotFoundException {
		ResultSet rs = dao0.buscarPorLogin(vo);
		
		try {
			ResponsavelVO generic = new ResponsavelVO();
			while(rs.next()) {
				generic.setId_pessoa(rs.getLong("responsavel.id_pessoa"));
				generic.setId_responsavel(rs.getLong("responsavel.id"));
				generic.setTelefone(rs.getString("telefone"));
				generic.setLogin(rs.getString("login"));
				generic.setSenha(rs.getString("senha"));
					
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
	public List<VO> listar() {
		ResultSet rs = dao0.listar();
		ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();
		
		try {
			while(rs.next()) {
				responsaveis.add(montarResponsavel(rs));
			}
			return (List<VO>) responsaveis;
		} catch (SQLException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void editar(VO vo) throws InsertException {
		try {
			if (this.buscarPorLogin(vo) != null)
				dao0.editar(vo);
		} catch (NotFoundException e) {
			throw new InsertException("Usuário não existe");
		}
		
	}

	@Override
	public void deletar(VO vo) throws InsertException {
		try {
			if (this.buscarPorLogin(vo) != null)
				if (vo instanceof ProprietarioVO) {
					ResultSet rs = dao1.buscarPorId((ProprietarioVO) vo);
					try {
						rs.next();
						((ProprietarioVO) vo).setId_proprietario(rs.getLong("proprietario.id"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dao1.deletar((ProprietarioVO) vo);
				} else {
					ResultSet rs = dao2.buscarPorId((FuncionarioVO) vo);
					try {
						rs.next();
						((FuncionarioVO) vo).setId_funcionario(rs.getLong("funcionario.id"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dao2.deletar((FuncionarioVO) vo);
				}
		} catch (NotFoundException e) {
			throw new InsertException("Usuário não existe");
		}
		
	}
	
	public ResponsavelVO montarResponsavel(ResultSet rs) throws NotFoundException{
		ResponsavelVO generic = new ResponsavelVO();
		try {
			generic.setId_pessoa(rs.getLong("responsavel.id_pessoa"));
			generic.setId_responsavel(rs.getLong("responsavel.id"));
			generic.setTelefone(rs.getString("telefone"));
			generic.setLogin(rs.getString("login"));
			generic.setSenha(rs.getString("senha"));
				
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

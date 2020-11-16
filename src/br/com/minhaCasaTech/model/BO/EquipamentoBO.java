package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.EquipamentoDAO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import exception.NotFoundException;


public class EquipamentoBO implements BaseInterBO<EquipamentoVO>{
	
	public void cadastrar(EquipamentoVO equipamento) {
		EquipamentoDAO edao = new EquipamentoDAO();
		edao.cadastrar(equipamento);
	}
	
	public void  editar(EquipamentoVO eqpOrigem) {
		EquipamentoDAO  edao = new EquipamentoDAO();
		edao.editar(eqpOrigem);
		
	}
	
	public void deletar(EquipamentoVO equipamento)throws SQLException{
		EquipamentoDAO edao = new EquipamentoDAO();
		//try {
			edao.deletar(equipamento);
			System.out.println("Deletado");
		/*} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("não deletado");
			
		}	*/	
		
	}
	
	
	public List<EquipamentoVO> listar(){
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listar();
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			while(rs.next()) {
				EquipamentoVO eqp = new EquipamentoVO();	
				eqp.setId_equipamento(rs.getLong("equipamento.id"));
				eqp.setNome(rs.getString("nome"));
				eqp.setPeso(rs.getDouble("peso"));
				eqp.setPreco(rs.getDouble("preco"));
				eqp.setQuantidade(rs.getInt("quantidade"));
				eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				
				LocalVO l = new LocalVO();
				LocalBO lbo = new LocalBO();
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	public EquipamentoVO buscarPorId(Long id) {
		EquipamentoVO eqp = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorId(id);
		
		try {
				rs.next();
					
				eqp.setId_equipamento(rs.getLong("id"));
				eqp.setNome(rs.getString("nome"));
				eqp.setPeso(rs.getDouble("peso"));
				eqp.setPreco(rs.getDouble("preco"));
				eqp.setQuantidade(rs.getInt("quantidade"));
				eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				
				LocalVO l = new LocalVO();
				LocalBO lbo = new LocalBO();
				
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorId(EquipamentoVO equipamento) {
		EquipamentoVO eqp = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorId(equipamento);
		try {
				rs.next();
					
				eqp.setId_equipamento(rs.getLong("id"));
				eqp.setNome(rs.getString("nome"));
				eqp.setPeso(rs.getDouble("peso"));
				eqp.setPreco(rs.getDouble("preco"));
				eqp.setQuantidade(rs.getInt("quantidade"));
				eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				
				LocalVO l = new LocalVO();
				LocalBO lbo = new LocalBO();
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return eqp;
	}
	
	
	public List<EquipamentoVO> buscarPorNome(String nome) {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorNome(nome);
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
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	
	public List<EquipamentoVO> buscarPorNS(int ns) {
		
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorNS(ns);
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
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	
	public List<EquipamentoVO> buscarPorLocal(String local) {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorLocal(local);
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
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
		
	}
	public List<EquipamentoVO> buscarPorResponsavel(String nome){
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarPorResponsavel(nome);
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
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	public List<EquipamentoVO> buscarGenerico(String campo){
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.buscarGenerico(campo);
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
				//LocalDAO ldao = new LocalDAO();
				//lbo.buscarPorId recebe um resultSet, e retorna um localvo. ldao.buscarPorId recebe um long e retorna 1 result set
				l =lbo.buscarPorId((rs.getLong("id_local")));
				eqp.setLocal(l);
				
				//mesma coisa sï¿½ q com responsavel
				
				ResponsavelVO r = new ResponsavelVO();
				ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
				try {
					r = rbo.buscarPorId(rs.getLong("id_responsavel"));
				} catch (NotFoundException e) {
					
					e.printStackTrace();
				}	
				eqp.setResponsavel(r);
				
				equipamentos.add(eqp);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return equipamentos;
	}
	public List<EquipamentoVO> buscarEntrePreco(double a, double b)  {
		EquipamentoDAO edao = new EquipamentoDAO();
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		
		try {
			ResultSet rs = edao.buscarEntrePreco(a, b);
			while(rs.next()) {
				EquipamentoVO eqp = new EquipamentoVO();	
				eqp.setId_equipamento(rs.getLong("e.id"));
				eqp.setNome(rs.getString("e.nome"));
				eqp.setPeso(rs.getDouble("e.peso"));
				eqp.setPreco(rs.getDouble("e.preco"));
				eqp.setQuantidade(rs.getInt("e.quantidade"));
				eqp.setNumeroDeSerie(rs.getInt("e.numero_de_serie"));
				
				LocalVO l = new LocalVO();
				l.setId(rs.getLong("l.id"));
				l.setCasa(rs.getString("l.casa"));
				l.setCompartimento(rs.getString("l.compartimento"));
				
				eqp.setLocal(l);
				
				ResponsavelVO resp = new ResponsavelVO();
				resp.setId_responsavel(rs.getLong("p2.id"));
				resp.setId_pessoa(rs.getLong("p2.id"));
				resp.setNome(rs.getString("p2.nome"));
				resp.setLogin(rs.getString("r2.login"));
				resp.setSenha(rs.getString("r2.senha"));
				resp.setEndereco(rs.getString("p2.endereco"));
				resp.setTelefone(rs.getString("r2.telefone"));
				//,p2.id,p2.nome,p2.endereco, r2.login,r2.senha, r2.telefone 
				
				eqp.setResponsavel(resp);
				
				
				equipamentos.add(eqp);
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i< equipamentos.size();i++) {
			System.out.println(equipamentos.get(i));
		}
		
		
		return equipamentos;
	}
	
}

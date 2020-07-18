package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.BO.PessoaBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;


public class EquipamentoDAO extends BaseDAO<EquipamentoVO> {
	
	public  void cadastrar(EquipamentoVO equipamento) {
		
		String sql = "insert into equipamento (nome,peso,preco,quantidade,numero_de_serie,id_local,id_responsavel) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,equipamento.getNome());
			pst.setDouble(2, equipamento.getPeso());
			pst.setDouble(3, equipamento.getPreco());
			pst.setInt(4, equipamento.getQuantidade());
			pst.setInt(5, equipamento.getNumeroDeSerie());
			pst.setLong(6, equipamento.getLocal().getId());
			pst.setLong(6, equipamento.getResponsavel().getId_responsavel());
			int affectedRows = pst.executeUpdate();
			if(affectedRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
			ResultSet key = pst.getGeneratedKeys();
			if(key.next()) {
				equipamento.setId_equipamento(key.getLong("id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(EquipamentoVO eqpOrigem) {
		String sql ="update equipamento nome = ?, peso = ?, preco = ? , quantidade = ?, numero_de_serie";
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1,eqpOrigem.getNome());
			pst.setDouble(2, eqpOrigem.getPeso());
			pst.setDouble(3, eqpOrigem.getPreco());
			pst.setInt(4, eqpOrigem.getQuantidade());
			pst.setInt(5, eqpOrigem.getNumeroDeSerie());
			
			pst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deletar(EquipamentoVO equipamento) {
		
		String sql = "delete from equipamento where id = ?";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setLong(1, equipamento.getId_equipamento());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ResultSet listar(){
		
		String sql = "select * from equipamento";
		Statement st;
		ResultSet rs = null;
		
		try {
			st = getCon().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			EquipamentoVO eqp = new EquipamentoVO();	
			eqp.setId_equipamento(rs.getLong("id"));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public EquipamentoVO buscarPorNome(String nome) {
		
		String sql = "select * from equipamento where nome = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, nome);
			rs = pst.executeQuery();
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
			
			/*ResponsavelVO r = new ResponsavelVO();
			PessoaBO<ResponsavelVO> rbo = new PessoaBO<ResponsavelBO>();
			ResponsavelDAO<ResponsavelVO> rdao = new ResponsavelDAO<ResponsavelVO>();
			*/
			//mesma coisa s� q com responsavel
			/*
			ResponsavelVO r = new ResponsavelVO();
			ResponsavelDAO rdao = new ResponsavelDAO();
			r = rdao.buscarId(rs.getLong("id_responsavel"));	
			eqp.setResponsavel(r);
			*/
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorNS(int ns) {
		
		
		String sql = "select * from equipamento where numero_de_serie = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setInt(1, ns);
			rs = pst.executeQuery();
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
public ResultSet buscarPorId(long id) {
		
		
		String sql = "select * from equipamento where id = ?";
		PreparedStatement pst;
		ResultSet rs = null;
	//	EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			/*eqp.setId_equipamento(rs.getLong("id"));
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
			*/
			//mesma coisa s� q com responsavel
			/*
			ResponsavelVO r = new ResponsavelVO();
			ResponsavelDAO rdao = new ResponsavelDAO();
			r = rdao.buscarId(rs.getLong("id_responsavel"));	
			eqp.setResponsavel(r);
			*/
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet buscarPorId(EquipamentoVO equipamento) {
		
		
		String sql = "select * from equipamento where id = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, equipamento.getId_equipamento());
			rs = pst.executeQuery();
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public EquipamentoVO buscarPorLocal(LocalVO local) {
	
		
		String sql = "select * from equipamento where id_local = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1,local.getId());
			rs = pst.executeQuery();
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
}

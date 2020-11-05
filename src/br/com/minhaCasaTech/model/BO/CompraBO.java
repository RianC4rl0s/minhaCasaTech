package br.com.minhaCasaTech.model.BO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.CompraDAO;
import br.com.minhaCasaTech.model.DAO.EquipamentoDAO;
import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.DAO.PessoaDAO;
import br.com.minhaCasaTech.model.DAO.ResponsavelDAO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import exception.InsertException;
import exception.NotFoundException;

public class CompraBO implements BaseInterBO<CompraVO> {
	static private CompraDAO dao0 = new CompraDAO();
	static private EquipamentoDAO dao1 = new EquipamentoDAO();
	static private LocalDAO dao2 = new LocalDAO();
	static private ResponsavelDAO dao3 = new ResponsavelDAO();
	static private PessoaDAO dao4 = new PessoaDAO();
	
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
		if (id < 0)
			throw new NotFoundException();
		else {
			ResultSet rs = dao0.buscarPorId(id);
			return montarCompra(rs);
		}
	}

	@Override
	public CompraVO buscarPorId(CompraVO vo) throws NotFoundException {
		ResultSet rs = dao0.buscarPorId(vo);
		return montarCompra(rs);
	}

	@Override
	public List<CompraVO> listar() throws NotFoundException {
		try {
			ResultSet rs = dao0.listar();
			ArrayList<CompraVO> compras = new ArrayList<CompraVO>();
			CompraVO generic = new CompraVO();
			
			while (rs.next()) {
				generic.setId_transacao(rs.getLong("id"));
				compras.add(this.buscarPorId(generic));
			}
			
			return compras;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}
	
	public List<CompraVO> gerarRelatorio(Calendar dataInicio, Calendar dataFim) throws NotFoundException{
		try {
			ResultSet rs = dao0.gerarRelatorio(dataInicio, dataFim, 1);
			ArrayList<CompraVO> compras = new ArrayList<CompraVO>();
			CompraVO generic = new CompraVO();
			
			while (rs.next()) {
				generic.setId_transacao(rs.getLong("id"));
				compras.add(this.buscarPorId(generic));
			}
			
			return compras;
		}catch (SQLException e) {
			throw new NotFoundException();
		}
	}
	
	public CompraVO montarCompra(ResultSet rs){
		try {
			while(rs.next()) {
				CompraVO generic = new CompraVO();
				Calendar data = Calendar.getInstance();
				generic.setId_compra(rs.getLong("compra.id"));
				generic.setId_transacao(rs.getLong("id_transacao"));
				
				ResultSet rs2 = dao0.buscarPorId(generic);
				
				while(rs2.next()) {
					generic.setValorTotal(rs2.getDouble("valor_total"));
					generic.setPesoTotal(rs2.getDouble("peso_total"));
					generic.setTotalEquip(rs2.getInt("total_equip"));
					data.setTime(rs2.getDate("data"));
					generic.setData(data);
					generic.setTipo(rs2.getInt("tipo"));
					generic.addEquipamento(montarEquipamento(rs2));
				}
		
				return generic;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public EquipamentoVO montarEquipamento(ResultSet rs) throws SQLException {
		ResultSet rs1 = dao1.buscarPorId(rs.getLong("transacao_equipamentos.id_equipamento"));
		rs1.next();
		
		EquipamentoVO eqp = new EquipamentoVO();
		eqp.setId_equipamento(rs1.getLong("id"));
		eqp.setNome(rs1.getString("nome"));
		eqp.setPeso(rs1.getDouble("peso"));
		eqp.setQuantidade(rs.getInt("transacao_equipamentos.quantidade"));
		eqp.setNumeroDeSerie(rs1.getInt("numero_de_serie"));
		eqp.setPreco(rs1.getDouble("preco"));
		
		ResultSet rs2 = dao2.buscarPorId(rs1.getLong("id_local"));
		rs2.next();
		LocalVO lcl = new LocalVO(rs2.getString("casa"),rs2.getString("compartimento"));
		lcl.setId(rs2.getLong("id"));
		
		ResultSet rs3 = dao3.buscarPorId(rs1.getLong("id_responsavel"));
		rs3.next();
		ResultSet rs4 = dao4.buscarPorId(rs3.getLong("id_pessoa"));
		rs4.next();
		ResponsavelVO rsp = new ResponsavelVO(rs4.getString("nome"), rs4.getString("endereco"), rs3.getString("telefone"));
		
		eqp.setLocal(lcl);
		eqp.setResponsavel(rsp);
		
		return eqp;
	}
	
	@Override
	public void editar(CompraVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(CompraVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}
}

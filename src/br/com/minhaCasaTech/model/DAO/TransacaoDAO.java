package br.com.minhaCasaTech.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;

public class TransacaoDAO<VO extends TransacaoVO> extends BaseDAO<VO>{
	
	public void cadastrar(VO transacao) {
		String sql = "insert into transacao (valor_total, peso_total, total_equip, data, tipo) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setDouble(1, transacao.getValorTotal());
			ptst.setDouble(2, transacao.getPesoTotal());
			ptst.setInt(3, transacao.getTotalEquip());
			ptst.setDate(4, new Date(transacao.getData().getTimeInMillis()));
			ptst.setInt(5, transacao.getTipo());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				transacao.setId_transacao(generatedKeys.getLong(1));
				this.cadastrarEquipamentos(transacao);
			}else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void cadastrarEquipamentos(VO transacao) {
		String sql = "insert into transacao_equipamentos (id_equipamento, id_transacao, quantidade) values (?,?,?)";
		PreparedStatement ptst;

		for (EquipamentoVO eqp : transacao.getEquipamentos())
		{
			try {
				ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ptst.setLong(1, eqp.getId_equipamento());
				ptst.setLong(2, transacao.getId_transacao());
				ptst.setInt(3, eqp.getQuantidade());
				
				int affectedRows = ptst.executeUpdate();
				
				if (affectedRows == 0)
					throw new SQLException("O registro de produtos falhou");
				
				ResultSet generatedKeys = ptst.getGeneratedKeys();
				
				if(!generatedKeys.next())
					throw new SQLException("O registro de produtos falhou");
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public ResultSet buscarPorId(VO transacao) {
		String sql = "select * from transacao, transacao_equipamentos where transacao.id=? and transacao_equipamentos.id_transacao=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, transacao.getId_transacao());
			ptst.setLong(2, transacao.getId_transacao());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listar() {
		String sql = "select * from transacao t inner join transacao_equipamentos te where te.id_transacao = t.id";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet buscarEquipamentoPorId(VO transacao) {
		String sql = "select * transacao_equipamentos where id_transacao=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, transacao.getId_transacao());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet gerarRelatorio(Calendar dataInicio, Calendar dataFim, int tipo) {
		String sql;
		
		if (tipo == 0)
			sql = "select * from transacao where not (data < ? or data > ?) and tipo = 0";
		else
			sql = "select * from transacao where not (data < ? or data > ?) and tipo = 1";
		
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setDate(1, new Date(dataInicio.getTimeInMillis()));
			ptst.setDate(2, new Date(dataFim.getTimeInMillis()));
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
	}

	@Override
	public void editar(VO entity) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletar(VO entity) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public ResultSet buscarPorId(Long id) throws SQLException {
		String sql = "select * from transacao where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, id);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

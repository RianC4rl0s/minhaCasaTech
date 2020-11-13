package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.PessoaVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class ProprietarioDAO<VO extends ProprietarioVO> extends ResponsavelDAO<VO> {
	public void cadastrar(VO pessoa) {
		super.cadastrar(pessoa);
		
		String sql = "insert into proprietario (id_responsavel, id_pessoa) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, pessoa.getId_responsavel());
			ptst.setLong(2, pessoa.getId_pessoa());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next())
				pessoa.setId_proprietario(generatedKeys.getLong(1));
			else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editar(VO pessoa) {
		super.editar(pessoa);
	}
	
	public ResultSet buscarPorId(VO pessoa) {
		String sql = "select * from pessoa, responsavel, proprietario where pessoa.id = ? and responsavel.id = ? and proprietario.id_responsavel = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.setLong(2, pessoa.getId_responsavel());
			ptst.setLong(3, pessoa.getId_responsavel());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorId(Long id) {
		String sql = "select * from proprietario where id=?";
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
	
	public ResultSet buscarPorIdResponsavel(Long id) {
		String sql = "select * from proprietario where id_responsavel=?";
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
	
	public ResultSet listar() {
		String sql = "select * from pessoa, responsavel, proprietario";
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
	
	public void deletar(VO pessoa) {
		String sql = "delete from proprietario where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_proprietario());
			ptst.executeUpdate();
			super.deletar(pessoa);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
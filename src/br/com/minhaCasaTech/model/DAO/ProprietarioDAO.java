package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.PessoaVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;

public class ProprietarioDAO extends ResponsavelDAO<ProprietarioVO> {
	public void cadastrar(ProprietarioVO pessoa) {
		super.cadastrar(pessoa);
		
		String sql = "insert into proprietario (id_responsavel) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, pessoa.getId_responsavel());
			
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
	
	public void editar(ProprietarioVO pessoa) {
		super.editar(pessoa);
	}
	
	public ResultSet buscarPorId(ProprietarioVO pessoa) {
		String sql = "select * from pessoa, responsavel, proprietario where pessoa.id = ?, responsavel.id = ?, proprietario.id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.setLong(2, pessoa.getId_responsavel());
			ptst.setLong(3, pessoa.getId_proprietario());
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
	
	public void deletar(ProprietarioVO pessoa) {
		super.deletar(pessoa);
		
		String sql = "delete from proprietario where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_proprietario());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
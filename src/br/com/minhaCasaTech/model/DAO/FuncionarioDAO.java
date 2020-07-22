package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.PessoaVO;

public class FuncionarioDAO<VO extends FuncionarioVO> extends ResponsavelDAO<VO> {
	public void cadastrar(VO pessoa) {
		super.cadastrar(pessoa);
		
		String sql = "insert into funcionario (id_responsavel, id_pessoa) values (?,?)";
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
				pessoa.setId_funcionario(generatedKeys.getLong(1));
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
		String sql = "select * from pessoa, responsavel, funcionario where pessoa.id = ? and responsavel.id = ? and funcionario.id_responsavel = ?";
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
		String sql = "select * from funcionario where id=?";
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
		String sql = "select * from pessoa, responsavel, funcionario";
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
		String sql = "delete from funcionario where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_funcionario());
			ptst.executeUpdate();
			super.deletar(pessoa);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

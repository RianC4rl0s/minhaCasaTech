package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.FuncionarioVO;

public class FuncionarioDAO extends ResponsavelDAO<FuncionarioVO> {
	public void cadastrar(FuncionarioVO pessoa) {
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
	
	public void editar(FuncionarioVO pessoa) {
		super.editar(pessoa);
	}
	
	public ResultSet buscarPorId(FuncionarioVO pessoa) {
		String sql = "select * from pessoa, responsavel, proprietario where pessoa.id = ?, responsavel.id = ?, funcionario.id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.setLong(2, pessoa.getId_responsavel());
			ptst.setLong(3, pessoa.getId_funcionario());
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
	
	public void deletar(FuncionarioVO pessoa) {
		super.deletar(pessoa);
		
		String sql = "delete from funcionario where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_funcionario());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

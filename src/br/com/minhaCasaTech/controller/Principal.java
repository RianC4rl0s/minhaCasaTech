package br.com.minhaCasaTech.controller;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.DAO.*;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import exception.NotFoundException;

public class Principal {
	public static void main(String args[]) throws SQLException {
		
	    System.out.println("================");

	    // BO
	    ResponsavelBO b1 = new ResponsavelBO();
	    
	    // VO
	    ProprietarioVO p1 = new ProprietarioVO("Junior", "FP", "99999999999", "juninho2", "seNha123!");
	    FuncionarioVO f1 = new FuncionarioVO("João", "FP", "88888888888", "joaozin", "seNha123!");
	    f1.setId_responsavel(new Long(69));
	    f1.setId_pessoa(new Long(85));
	    f1.setId_funcionario(new Long(60));
	    // TESTE
	    System.out.println(b1.listar());
	    b1.deletar(f1);
	    System.out.println(b1.listar());
	}
}

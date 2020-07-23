package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML TextField login_txf;
	@FXML TextField senha_pf;
	@FXML Label erro_login_lb;
	@FXML Label error_senha_lb;
	
	public void autenticar(){
		ResponsavelVO resp = new ResponsavelVO();
		resp.setLogin(login_txf.getText());
		ResponsavelBO<ResponsavelVO> rbo= new ResponsavelBO<>();
		ResponsavelVO respAuten = new ResponsavelVO();
		try {
			Telas.telaPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

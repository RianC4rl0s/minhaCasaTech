package br.com.minhaCasaTech.controller;

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
		
		try {
			Telas.telaPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.NotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginAdminController {
	@FXML TextField login_txf;
	@FXML TextField senha_pf;
	@FXML Label erro_login_lb;
	@FXML Label error_senha_lb;
	@FXML
    private Label erro_permissao;
	public void autenticar(){
	
		
		if(senha_pf.getText().equals("") | login_txf.getText().equals("")) {
			erro_login_lb.setVisible(true);
			error_senha_lb.setVisible(true);
			System.out.println("é sem nada");
		}else {
			ResponsavelVO resp = new ResponsavelVO();
			resp.setLogin(login_txf.getText());
			ResponsavelBO<ResponsavelVO> rbo= new ResponsavelBO<>();
			ResponsavelVO respAuten = new ResponsavelVO();
			try {
				respAuten = rbo.buscarPorLogin(resp);
				System.out.println("Autenticou");
			} catch (NotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(respAuten.getLogin().equals(login_txf.getText()) && respAuten.getSenha().equals(senha_pf.getText())){
				System.out.println("Senha e user conferem");
				if(respAuten instanceof ProprietarioVO) {
					try {
						Telas.telaPrincipal();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					 erro_permissao.setVisible(true);
				}
		}
			else {
			erro_login_lb.setVisible(true);
			error_senha_lb.setVisible(true);
		}
			
		}
	}
	public void fechar() {
		try {
			Telas.fecharTela();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void voltarInicio() {
		try {
			Telas.telaPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

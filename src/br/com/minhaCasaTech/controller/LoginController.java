package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.NotFoundException;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML TextField login_txf;
	@FXML TextField senha_pf;
	@FXML Label erro_login_lb;
	@FXML Label error_senha_lb;
	 @FXML
	    private Label erro_senha_format;
	public void autenticar(){
	
		
		if(senha_pf.getText().equals("") | login_txf.getText().equals("")) 
		{
			erro_login_lb.setVisible(true);
			error_senha_lb.setVisible(true);
		} 
		else
		{
			if(senha_pf.getText().matches("(.*)([a-zA-Z][0-9])(.*)") == true) 
			{
				ResponsavelVO resp = new ResponsavelVO();
				resp.setLogin(login_txf.getText());
				ResponsavelBO<ResponsavelVO> rbo= new ResponsavelBO<>();
				
				try {
					resp = rbo.buscarPorLogin(resp);
					System.out.println("Autenticou");
				} catch (NotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(resp.getLogin().equals(login_txf.getText()) && resp.getSenha().equals(senha_pf.getText()))
				{
					
					System.out.println("Senha e user conferem");
					
					try {
						if(rbo.isProprietario(resp.getId_responsavel())) {
							try {
								Telas.telaSelecionarSetor();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								System.out.println("nao foi possivel entrar na tela");
							}
						}else {
							try {
								Telas.telaPrincipal();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} 
				else 
				{					
				erro_login_lb.setVisible(true);
				error_senha_lb.setVisible(true);
				}
			}
			else 
			{
				System.out.println("A senha deve conter caracteres Maiusculos, minusculos e numeros");
				erro_senha_format.setVisible(true);
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
}

/*if(respAuten instanceof ProprietarioVO) {
System.out.println("� proprietario");
	try {
		Telas.telaPrincipal();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}else if(respAuten instanceof FuncionarioVO) {
System.out.println("� funcionario");	
try {
		Telas.telaPrincipalFuncionario();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/

package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarLocalController {
	@FXML TextField casa_cad_txf;
	@FXML TextField compartimento_cad_txf;
	@FXML Button cadastar_local_btm;
	public void cadastrarLocal() {
		LocalVO l = new LocalVO(casa_cad_txf.getText(),compartimento_cad_txf.getText());
		LocalBO lbo = new LocalBO(); 
		lbo.cadastrar(l);
		Stage stage = (Stage) cadastar_local_btm.getScene().getWindow(); //Obtendo a janela atual
		try {
			Telas.telaGerenciarLocal();
		} catch (Exception e) {
			
		}
		stage.close(); //Fechando o Stage
		
	}
	public void limparCampos() {
		compartimento_cad_txf.setText("");
		casa_cad_txf.setText("");
	}
	@FXML Button cancelar_btm = new Button();
	public void cancelarOperacao(){
	    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
}

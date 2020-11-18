package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;


import br.com.minhaCasaTech.model.BO.ResponsavelBO;

import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeletarResponsavelController implements Initializable {
	@FXML private RadioButton radioProp;
	@FXML private RadioButton radioFunc;
	@FXML private Label errorLabel;
	@FXML private Button cancelar;

	private static DeletarResponsavelController delController;
	private ResponsavelVO resp = new ResponsavelVO();
	
	public static DeletarResponsavelController getDelController() {
		return delController;
	}

	public static void setDelController(DeletarResponsavelController delController) {
		DeletarResponsavelController.delController = delController;
	}

	public ResponsavelVO getResp() {
		return resp;
	}

	public void setResp(ResponsavelVO resp) {
		this.resp = resp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
	
	public void deletarResponsavel() {		
		if (!radioProp.isSelected() && !radioFunc.isSelected())
			errorLabel.setVisible(true);
		else {
			ResponsavelBO<ResponsavelVO> bo = new ResponsavelBO();
			ResponsavelVO r;
			
			if (radioProp.isSelected())
				try {
					r = new ProprietarioVO(resp.getNome(),resp.getEndereco(),resp.getTelefone(),resp.getLogin(), resp.getSenha());
					r.setId_pessoa(resp.getId_pessoa());
					r.setId_responsavel(resp.getId_responsavel());
					bo.deletar(r);
				} catch (InsertException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				try {
					r = new FuncionarioVO(resp.getNome(),resp.getEndereco(),resp.getTelefone(),resp.getLogin(), resp.getSenha());
					r.setId_pessoa(resp.getId_pessoa());
					r.setId_responsavel(resp.getId_responsavel());
					bo.deletar(r);
				} catch (InsertException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Não pode deletar");
				}			
			
			Stage stage = (Stage) radioProp.getScene().getWindow(); 
			stage.close();
			try {
				Telas.telaSetorProprietario();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}

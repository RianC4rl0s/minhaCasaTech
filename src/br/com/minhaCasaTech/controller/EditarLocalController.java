//ESSA É A TELA QUE TENHO PROBLEMA

package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarLocalController implements Initializable {
	@FXML
    private Button clear_local_btm;
    @FXML
    private Button cancel_local_btm;
    @FXML
    private TextField casa_edt_txf;
    
    @FXML
    private TextField compartimento_edt_txf;
    
    private LocalVO l = new LocalVO();
    private static EditarLocalController meuController;

    public static EditarLocalController getMenuController() {
		return meuController;
	}
	public static void setMenuController(EditarLocalController menuController) {
		EditarLocalController.meuController = menuController;
	}
	
public void initialize(URL url, ResourceBundle rb) {
	setValores();
	meuController = this;
}
public void setValores() {
	casa_edt_txf.setText(l.getCasa());
	compartimento_edt_txf.setText(l.getCompartimento());
}

public LocalVO getL() {
	return l;
}
public void setL(LocalVO l) {
	this.l = l;
}

@FXML Button cancelar_btm = new Button();

@FXML
private void cancelarOperacao(){
    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
    stage.close(); //Fechando o Stage
   
}

@FXML
private Button editar_local_btm;
public void confirmarEdicao() {
	System.out.println(l.getId());
	LocalBO lbo = new LocalBO();
	l.setCasa(casa_edt_txf.getText());
	l.setCompartimento(compartimento_edt_txf.getText());

	lbo.editar(l);
	try {
		Telas.telaGerenciarLocal();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}

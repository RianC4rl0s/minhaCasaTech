package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.VO.LocalVO;
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
    private Button editar_local_btm;
    @FXML
    private TextField compartimento_edt_txf;
    
    private LocalVO l;
public void initialize(URL url, ResourceBundle rb) {
	setValores();
}
public EditarLocalController(LocalVO local) {
	 this.l = local;
	
}
public void setValores() {
	casa_edt_txf.setText(l.getCasa());
	compartimento_edt_txf.setText(l.getCompartimento());
}
@FXML Button cancelar_btm = new Button();

@FXML
private void cancelarOperacao(){
    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
    stage.close(); //Fechando o Stage
}
}

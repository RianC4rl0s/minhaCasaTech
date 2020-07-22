package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;


import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarEquipamentoController implements Initializable{
	@FXML
    private Button editar_eqp_btm;
    @FXML
    private Button cancelar_btm;
    
    
    private static EditarEquipamentoController meuController;
    
	private EquipamentoVO e = new EquipamentoVO();
	
	public static EditarEquipamentoController getMeuController() {
		return meuController;
	}
	public static void setMeuController(EditarEquipamentoController meuController) {
		EditarEquipamentoController.meuController = meuController;
	}
	public EquipamentoVO getE() {
		return e;
	}
	public void setE(EquipamentoVO e) {
		this.e = e;
	}
	
	
	public void initialize(URL url, ResourceBundle rb) {
		setValores();
		meuController = this;
	}
	@FXML
    private TextField ns_edt_txf;
    @FXML
    private TextField quantidade_edt_txf;
    @FXML
    private TextField peso_edt_txf;
    @FXML
    private TextField preco_edt_txf;
    @FXML
    private TextField nome_edt_txf;
    @FXML
    private ComboBox<LocalVO> local_edt_txf;
	
    @FXML
    private Label ultimo_local_jlb;
    public void setValores() {
		nome_edt_txf.setText(e.getNome());
		quantidade_edt_txf.setText(String.valueOf(e.getQuantidade()));
		peso_edt_txf.setText(String.valueOf(e.getPeso()));
		preco_edt_txf.setText(String.valueOf(e.getPreco()));
		ns_edt_txf.setText(String.valueOf(e.getNumeroDeSerie()));
		
		LocalBO lbo = new LocalBO();
		local_edt_txf.setItems(FXCollections.observableArrayList(lbo.listar()));
		//String ls = e.getLocal().getCasa() +" "+ e.getLocal().getCompartimento();
		/*LocalVO lvo = new LocalVO();
		lvo = e.getLocal();*/
		//System.out.println(e.getLocal().toString());
		//ultimo_local_jlb.setText(ls);
	}
	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	   
	}
}

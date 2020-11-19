//ESSA É A TELA ONDE EU PEGO OS DADOS DA TABELA
package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciarLocalController implements Initializable {
	//Tela Gerenciar local
	public void voltarInicio() {
		try {
			Telas.telaPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void sair() {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void chamarTelaCadastrarLocal() {
		try {
			Telas.telaCadastrarLocal();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	public void chamarTelaEditarLocal(LocalVO l) {
		try {
			 System.out.println("Abrir tela editar");
			Telas.telaEditarLocal(l);
			 System.out.println("Abrir tela editar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @FXML
    private Label exception_jlb;
	public void editarItem() {
		//aqui eu pego os dados da tabela e chamo a proxima tela
		TableViewSelectionModel<LocalVO> selectionModel = tabela_locais.getSelectionModel();
		 if(selectionModel.getSelectedItem() == null) {
				exception_jlb.setText("Nenhum item selecionado");
		 }else {
			
				 try {  
						exception_jlb.setText("");
					
						System.out.println(selectionModel.getSelectedItem().toString());
						chamarTelaEditarLocal(selectionModel.getSelectedItem());
					}catch(Exception e) {
						//exception_jlb.setText("Nenhum item selecionado");
						e.printStackTrace();
					}
		 }
	   }
	public void recarregarTela() {
		try {
			Telas.telaGerenciarLocal();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void initialize(URL url, ResourceBundle rb) {
		initTable();
	}
		@FXML TableView<LocalVO> tabela_locais;
	    @FXML TableColumn<LocalVO,String> local_casa;
	    @FXML TableColumn<LocalVO, String> local_compartimento;
	    public void initTable(){
	    	local_casa.setCellValueFactory(new PropertyValueFactory<>("Casa"));
	    	local_compartimento.setCellValueFactory(new PropertyValueFactory<>("Compartimento"));
	    	
	    	LocalBO lbo = new LocalBO();
	    	tabela_locais.setItems(FXCollections.observableArrayList(lbo.listar()));
	 }
	    @FXML
	    private Label excep_delet_error;
	 public void excluirItem(){
		 LocalBO lbo = new LocalBO();
		 TableViewSelectionModel<LocalVO> selectionModel = tabela_locais.getSelectionModel();
		 if(selectionModel.getSelectedItem() == null) {
			 exception_jlb.setText("Nenhum item selecionado");
		 }else {
			
			 try {
				 exception_jlb.setText("");
				
			
				 lbo.deletar(selectionModel.getSelectedItem());
				
				 recarregarTela();
			 }catch(Exception e) {
				 excep_delet_error.setVisible(true);
				// exception_jlb.setText("Nenhum item selecionado");
			 }
	 }
		
	 } 
	   
}

package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciarEquipamentoController implements Initializable{

    @FXML
    private ToggleGroup grupoRadio;

    @FXML
    private Button cadastrar_eqp_btm;
    @FXML
    private Button sair_btm;
    @FXML
    private Button excluir_eqp_btm;
    @FXML
    private Button editar_eqp_btm;
    
    
 
   
    @FXML
    private Button buscar_btt;
  
 
	
	
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
	public void chamarTelaCadastrarEquipamento() {
		try {
			Telas.telaCadastrarEquipamento();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	public void initialize(URL url, ResourceBundle rb) {
		iniciarTabela();
	}
		@FXML
	    private TableColumn<EquipamentoVO, String> quantidade_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, String> ns_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, String> nome_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, String> peso_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, String> reponsavel_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, String> preco_coluna_tb;
	    @FXML
	    private TableColumn<EquipamentoVO, LocalVO> local_coluna_tb;
	    @FXML
	    private TableView<EquipamentoVO> tabela_equipamento;
	
	    
	    public void iniciarTabela() {
	    	nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
	    	preco_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("preco"));
	    	peso_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("peso"));
	    	quantidade_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
	    	ns_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
 	
	    	local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
	    	reponsavel_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
	    	
	    	EquipamentoBO ebo = new EquipamentoBO();
	    	tabela_equipamento.setItems(FXCollections.observableArrayList(ebo.listar()));
	    }
	    public void chamarTelaEditarEquipamento(EquipamentoVO e) {
	    	try {
				Telas.telaEditarEquipamento(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    @FXML
	    private Label exception_jlb;
	    public void editarItem() {
	    	try {
	    		exception_jlb.setText("");
	    		TableViewSelectionModel<EquipamentoVO> selectionModel = tabela_equipamento.getSelectionModel();
		    	chamarTelaEditarEquipamento(selectionModel.getSelectedItem());
		    	System.out.println(selectionModel.getSelectedItem().getLocal().getCasa());
			} catch (Exception e) {
				exception_jlb.setText("Nenhum item selecionado");
			}
	    	
	    }
	    public void excluirEquipamento() {
	    	
	    	TableViewSelectionModel<EquipamentoVO> selectedModel = tabela_equipamento.getSelectionModel();
	    	if( selectedModel == null) {
	    		exception_jlb.setText("Nenhum item selecionado");
	    	}else{
		    	try {
		    		exception_jlb.setText("");
			    	EquipamentoBO ebo = new EquipamentoBO();
			    	
			    	
			    	ebo.deletar(selectedModel.getSelectedItem());
				} catch (Exception e) {
					
				}
	    	}
	    	
	    	
	    	recarregarTela();
	    }
	    
	    @FXML
	    private RadioButton nome_eqp_rdb1;
	    @FXML
	    private RadioButton local_eqp_rdb2;
	    @FXML
	    private RadioButton ns_eqp_rdb3;
	    @FXML
	    private RadioButton responsavel_eqp_rdb4;
	    @FXML
	    private TextField buscar_txf;
	    
	    public void realizarBuscar() {
	    
	    	EquipamentoBO ebo = new EquipamentoBO();
	    	//RadioButton rb = (RadioButton) grupoRadio.getProperties();
	    	List<EquipamentoVO> eqpL= new ArrayList<>();
	    	
	    	System.out.println(nome_coluna_tb.getText());
	    	//System.out.println(eqpL.get(0).getNome());
	    	if(nome_eqp_rdb1.isSelected()) {
	    		eqpL = ebo.buscarPorNome(buscar_txf.getText());
	    	}else if(local_eqp_rdb2.isSelected()) {
	    		eqpL = ebo.buscarPorLocal(buscar_txf.getText());
	    		System.out.println("local");
	    	}else if(ns_eqp_rdb3.isSelected()) {
	    		eqpL = ebo.buscarPorNS(Integer.parseInt(buscar_txf.getText()));
	    		System.out.println("ns");
	    	}else if(responsavel_eqp_rdb4.isSelected()){
	    		System.out.println("resp");
	    		//ebo.buscarPorResponsavel(buscar_txf.getText());
	    	}
	    	preencherTabelaBusca(eqpL);
	    }
	    public void preencherTabelaBusca(List<EquipamentoVO> equipamentos) {
	    	nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
	    	preco_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("preco"));
	    	peso_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("peso"));
	    	quantidade_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
	    	ns_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
 	
	    	local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
	    	reponsavel_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
	    	
	    	
	    	tabela_equipamento.setItems(FXCollections.observableArrayList(equipamentos));
	    }
	    public void recarregarTela() {
			try {
				Telas.telaGerenciarEquipamento();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
}

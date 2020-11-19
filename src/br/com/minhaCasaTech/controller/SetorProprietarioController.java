package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.DAO.ProprietarioDAO;
import br.com.minhaCasaTech.model.VO.CaixaVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import br.com.minhaCasaTech.model.VO.logVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SetorProprietarioController implements Initializable {
	@FXML
	private ToggleGroup grupoRadio;
	@FXML
	private Button cadastrar;
	@FXML
	private Button sair_btm;
	@FXML
	private Button excluir;
	@FXML
	private Button editar_eqp_btm;	   
	@FXML
	private Button buscar_btt;
	@FXML private RadioButton radioProp;
	@FXML private RadioButton radioFunc;
	@FXML private Label errorLabel;
	
	@FXML
    private TableColumn<logVO, String> log_data;
	@FXML
    private TableColumn<logVO, String> log_act;
    @FXML
	private TableColumn<logVO, String> log_user;
	@FXML
	private TableView<logVO> tabela_log;
	  	
	public void voltarInicio() {
		try {
			//Telas.telaGerenciarResponsavel();
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
	
	public void initialize(URL url, ResourceBundle rb) {
		iniciarTabela();
		iniciarCaixa();
		carregarCaixas();
		iniciarTabelaLog();
	}
	
	@FXML
    private TableColumn<ResponsavelVO, Long> id_responsavel;
	@FXML
    private TableColumn<ResponsavelVO, String> nome;
    @FXML
	private TableColumn<ResponsavelVO, String> endereco;
	@FXML
	private TableColumn<ResponsavelVO, String> telefone;
	@FXML
	private TableView<ResponsavelVO> tabela_responsaveis;
	
	public void chamarTelaCadastrarResponsavel() {
		try {
			Telas.telaCadastrarResponsavel();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

   
	public void chamarTelaEditarResponsavel() {
		TableViewSelectionModel<ResponsavelVO> selectedModel = tabela_responsaveis.getSelectionModel();
		if(selectedModel.getSelectedItem()== null) {
    		exception_jlb.setText("Nenhum item selecionado");
    	}else{
			try {
				
		    		Telas.telaEditarResponsavel(selectedModel.getSelectedItem());
		    		
		    	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
		
    public void iniciarTabela() {
    	id_responsavel.setCellValueFactory(new PropertyValueFactory<>("id_responsavel"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));    	
		    	
		ResponsavelBO rbo = new ResponsavelBO();
		tabela_responsaveis.setItems(FXCollections.observableArrayList(rbo.listar()));
	}
    
    public void iniciarTabelaLog() {
    	log_data.setCellValueFactory(new PropertyValueFactory<>("data"));
		log_act.setCellValueFactory(new PropertyValueFactory<>("modificacao"));
		log_user.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		    	
		ProprietarioDAO dao = new ProprietarioDAO();
		ResultSet rs = dao.listarLog();
		List<logVO> lst = new ArrayList<>();
		
		try {
			while (rs.next()) {
				logVO log = new logVO();
				log.setData(rs.getString("data"));
				log.setModificacao(rs.getString("modificacao"));
				log.setUsuario(rs.getString("usuario"));
				lst.add(log);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tabela_log.setItems(FXCollections.observableArrayList(lst));
	}
		    
    @FXML
    private Label excep_delet_error;
    public void excluirResponsavel() {
    	TableViewSelectionModel<ResponsavelVO> selectedModel = tabela_responsaveis.getSelectionModel();
		if( selectedModel.getSelectedItem()== null) {
    		exception_jlb.setText("Nenhum item selecionado");
    	}else{
	    	try {
	    		
		    		Telas.telaDeletarResponsavel(selectedModel.getSelectedItem());
		    		
				
	    	} catch (Exception e) {
				e.printStackTrace();
				//excep_delet_error.setVisible(true);
			}
    	}
	}
    @FXML
    private TextField caixa_txf;
    public void iniciarCaixa() {
		CaixaVO c = new CaixaVO();
		CaixaBO cbo = new CaixaBO();
		c = cbo.pegarValor();
		caixa_txf.setText( String.valueOf(c.getValor()));
	}
    public void chamarTelaRelatorio() {
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @FXML private TextField ns_equipamento_txf;
    @FXML private TextField preco_equipamento_txf;
    @FXML private ComboBox<LocalVO> select_local_cbb;
    @FXML private ComboBox<ResponsavelVO> select_responsavel_bb;
    @FXML private TextField nome_equipamento_txf;
    @FXML private Button cancelar_btm;
    @FXML private Button cadastrar_equipamento_btm;
    @FXML private TextField peso_equipamento_txf;
    @FXML private TextField quantidade_equipamento_txf;
    /*private void cancelarOperacao(){
	   limparCampos();
	}*/
    public void carregarCaixas() {
		LocalBO lbo = new LocalBO();
		ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
		select_local_cbb.setItems(FXCollections.observableArrayList(lbo.listar()));
		select_responsavel_bb.setItems(FXCollections.observableArrayList(rbo.listar()));
	}
    @FXML
    private TextField mudar_valor_txf;
    @FXML
    private RadioButton sub_caixa_rbtm2;
    @FXML
    private RadioButton add_caixa_rbm1;
    @FXML
    private RadioButton alter_caixa_rbtm3;
    @FXML
    private Pane alert_pop_up_pane;
    public void showPopUp() {
    	alert_pop_up_pane.setVisible(true);
    }
    public void closePopUp() {
    	alert_pop_up_pane.setVisible(false);
    }
    public void editarCaixa() {
    	if (mudar_valor_txf.getText().matches("\\d{0,7}([\\.]\\d{0,4})?")) {
    		double valor = Double.parseDouble( mudar_valor_txf.getText());
    		CaixaBO cbo = new CaixaBO();
        	if(add_caixa_rbm1.isSelected()) {
        		cbo.addValor(valor);
        	}else if(sub_caixa_rbtm2.isSelected()) {
        		cbo.subValor(valor);
        	}else if(alter_caixa_rbtm3.isSelected()) {
        		cbo.alterarValor(valor);
        	}
        	iniciarCaixa();
        	closePopUp();
    	}else {
    		System.out.println("N�o � double");
    	}
    	
    
    }
	@FXML
    private Label exception_jlb;
    public void cadastrarEquipamento() {
		EquipamentoVO e = new EquipamentoVO();
		e.setNome(nome_equipamento_txf.getText());
		e.setPeso(Double.parseDouble(peso_equipamento_txf.getText()));
		e.setPreco(Double.parseDouble(preco_equipamento_txf.getText()));
		e.setQuantidade(Integer.parseInt(quantidade_equipamento_txf.getText()));
		e.setNumeroDeSerie(Integer.parseInt(ns_equipamento_txf.getText()));
		e.setLocal(select_local_cbb.getSelectionModel().getSelectedItem());
		e.setResponsavel(select_responsavel_bb.getSelectionModel().getSelectedItem());
		
		EquipamentoBO ebo = new EquipamentoBO();
		ebo.cadastrar(e);
		double valorTotal = e.getPreco() * e.getQuantidade();
		/*CaixaBO cbo = new CaixaBO();
		cbo.subValor(valorTotal);*/
		try {
			Telas.telaGerenciarEquipamento();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    public void limparCampos() {
    	   ns_equipamento_txf.setText("");;
    	   preco_equipamento_txf.setText("");
    	 
    	   nome_equipamento_txf.setText("");
    	   cancelar_btm.setText("");
    	   cadastrar_equipamento_btm.setText("");
    	   peso_equipamento_txf.setText("");
    	   quantidade_equipamento_txf.setText("");
    }
    
}

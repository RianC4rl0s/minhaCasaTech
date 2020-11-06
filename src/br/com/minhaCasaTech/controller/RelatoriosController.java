package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.TransacaoBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import br.com.minhaCasaTech.view.Telas;
import exception.NotFoundException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class RelatoriosController implements Initializable {
	private TransacaoBO tbo = new TransacaoBO();
	private VendaBO vbo = new VendaBO();
	private CompraBO cbo = new CompraBO();
	
	static LocalDate localDateI;
	static LocalDate localDateF;
	
	@FXML private TableView tabela_vendas;
	@FXML private TableColumn<TransacaoVO, Long> id_coluna_tb1;
	@FXML private TableColumn<TransacaoVO, Double> vt_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Double> peso_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Integer> totalEqp_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Calendar> data_coluna_tb1;
	@FXML private TableView tabela_compras;
	@FXML private TableColumn<TransacaoVO, Long> id_coluna_tb2;
	@FXML private TableColumn<TransacaoVO, Double> vt_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Double> peso_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Integer> totalEqp_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Calendar> data_coluna_tb2;
    
    @FXML private DatePicker dI;
    @FXML private DatePicker dF;
    @FXML private Button verEqps;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciarTabelaCompras();
		iniciarTabelaVendas();
	}
	
	public void iniciarTabelaVendas() {
    	id_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("id_transacao"));
    	vt_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	peso_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
    	totalEqp_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
    	data_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("data"));
    	data_coluna_tb1.setCellFactory(coluna -> {
			return new TableCell<TransacaoVO,Calendar>(){
				//CRIA UM FORMATO
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				@Override
				protected void updateItem(Calendar item, boolean empty) {
					super.updateItem(item, empty);
					if(item == null||empty) {
						setText(null);
					}else {
						//.GETTIME RETORNA UM DATE POR ISSO O SIMPLEDATEFORMAT FUNCIONA
						setText(formato.format(item.getTime()));
					}
				}
			};
    	});
    
    	try {
    		Calendar cI = Calendar.getInstance();
    		if (localDateI != null)
    			cI.set(localDateI.getYear(),localDateI.getMonthValue()-1,localDateI.getDayOfMonth());
    		
    		Calendar cF = Calendar.getInstance();
    		if (localDateF != null)
    			cF.set(localDateF.getYear(),localDateF.getMonthValue()-1,localDateF.getDayOfMonth());    
    		
			tabela_vendas.setItems(FXCollections.observableArrayList(vbo.gerarRelatorio(cI, cF)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void iniciarTabelaCompras() {
		id_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("id_transacao"));
    	vt_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	peso_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
    	totalEqp_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
    	data_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("data"));
    	data_coluna_tb2.setCellFactory(coluna -> {
			return new TableCell<TransacaoVO,Calendar>(){
				//CRIA UM FORMATO
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				@Override
				protected void updateItem(Calendar item, boolean empty) {
					super.updateItem(item, empty);
					if(item == null||empty) {
						setText(null);
					}else {
						//.GETTIME RETORNA UM DATE POR ISSO O SIMPLEDATEFORMAT FUNCIONA
						setText(formato.format(item.getTime()));
					}
				}
			};
    	});
    
    	try {
    		Calendar cI = Calendar.getInstance();
    		if (localDateI != null)
    			cI.set(localDateI.getYear(),localDateI.getMonthValue()-1,localDateI.getDayOfMonth());
    		
    		Calendar cF = Calendar.getInstance();
    		if (localDateF != null)
    			cF.set(localDateF.getYear(),localDateF.getMonthValue()-1,localDateF.getDayOfMonth());    		
    		
			tabela_compras.setItems(FXCollections.observableArrayList(cbo.gerarRelatorio(cI, cF)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void gerarRelatorio() {		
		try {			
			this.localDateI = dI.getValue();
			this.localDateF = dF.getValue();
			Telas.telaRelatorio();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciarTabelaEquipamentos(TransacaoVO vo){
		try {
			Telas.telaMostrarEquipamentos(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verEquipamentos() {
		TableViewSelectionModel<TransacaoVO> selectionModelVendas = tabela_vendas.getSelectionModel();
		TableViewSelectionModel<TransacaoVO> selectionModelCompras = tabela_compras.getSelectionModel();
    	if(selectionModelVendas.getSelectedItem() != null || selectionModelCompras.getSelectedItem() != null) {
    		if (selectionModelVendas.getSelectedItem() != null) {
    			iniciarTabelaEquipamentos(selectionModelVendas.getSelectedItem());
    		}else
    		{
    			iniciarTabelaEquipamentos(selectionModelCompras.getSelectedItem());
    		}
    	}
	}
	
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
}

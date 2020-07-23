package br.com.minhaCasaTech.controller;

import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatoriosController implements Initializable {
	private TransacaoBO tbo = new TransacaoBO();
	private VendaBO vbo = new VendaBO();
	private CompraBO cbo = new CompraBO();
	
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
    @FXML private TableColumn<TransacaoVO, Date> data_coluna_tb2;
    
    @FXML private DatePicker dI;
    @FXML private DatePicker dF;

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
    
    	try {
    		/*LocalDate localDate = dI.getValue();
    		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    		Date date = Date.from(instant);*/
    		
    		Calendar cI = Calendar.getInstance();
    		cI.set(2020,07,22);
    		
    		/*LocalDate localDate2 = dF.getValue();
    		Instant instant2 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    		Date date2 = Date.from(instant);*/
    		Calendar cF = Calendar.getInstance();
    		cF.set(2020,07,23);
    		
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
    
    	try {
    		Calendar cI = Calendar.getInstance();
    		/*dI.init(cI.get(Calendar.YEAR), cI.get(Calendar.MONTH), cI.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
    	        @Override
    	        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    	            cI.set(i, i2, i3);
    	        }});
    		
    		*/
    		cI.set(2020,06,22);
    		
    		/*LocalDate localDate2 = dF.getValue();
    		Instant instant2 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    		Date date2 = Date.from(instant);*/
    		Calendar cF = Calendar.getInstance();
    		cF.set(2020,06,23);
    		
    		
    		System.out.println(cbo.gerarRelatorio(cI, cF));
			tabela_compras.setItems(FXCollections.observableArrayList(cbo.gerarRelatorio(cI, cF)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void gerarRelatorio() {		
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

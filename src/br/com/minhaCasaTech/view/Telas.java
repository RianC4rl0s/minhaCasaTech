package br.com.minhaCasaTech.view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
private static Stage primaryStage;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static void main(String args[]) {
		launch();
		}
		
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("MinhaCasaTECH");
		primaryStage.show();
		telaLogin();
		
		
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	public static void telaPrincipal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		
	}
	public static void telaCadastrarEquipamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarEquipamento.fxml"));
		
		Scene cena = new Scene(root);
		Stage secondarySage = new Stage();
		secondarySage.setTitle("MinhaCasaTECH");
		secondarySage.show();
		secondarySage.setScene(cena);
		
		
	}
	public static void telaGerenciarEquipamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarEquipamento.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		
	}
	public static void telaCadastrarResponsavel() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarResponsavel.fxml"));
		Scene cena = new Scene(root);
		Stage secondarySage = new Stage();
		secondarySage.setScene(cena);
		secondarySage.setTitle("MinhaCasaTECH");
		secondarySage.show();
	
	}
	public static void telaGerenciarResponsavel() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarResponsavel.fxml"));
		Scene cena  = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	public static void telaGerenciarCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarCliente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaGerenciarLocal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarLocal.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaCadastrarLocal() throws Exception{

		Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastrarLocal.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("MinaCasaTECH");
		secondaryStage.setScene(cena);
		secondaryStage.show();
	
	}
}

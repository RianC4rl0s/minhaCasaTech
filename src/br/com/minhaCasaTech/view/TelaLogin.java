package br.com.minhaCasaTech.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLogin extends Application {
	public static void main(String args[]) {
		launch();
		}
		
public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("VE/TelaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
}

package gui;

import javafx.application.Application;
import app.UndirectedGraph;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;

import javafx.scene.Scene;

import javafx.scene.control.SplitPane;


public class Main extends Application{	
	
	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
		UndirectedGraph graph = new UndirectedGraph();
		
		SplitPane root = loader.load();
		
		GraphController<UndirectedGraph> some = new GraphController<UndirectedGraph>();
		
		
		
		Scene scene = new Scene(root);
		
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

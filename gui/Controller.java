package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class Controller {
	@FXML
	private CheckBox drawVertices;
	@FXML
	private AnchorPane drawSpace;
	
	private DrawVertex vertexDrawer = new DrawVertex();
	
	public void enableDrawVerties(ActionEvent event) {
		
		if(drawVertices.isSelected()) {
			drawSpace.setOnMouseClicked(vertexDrawer);
		} else {
			drawSpace.setOnMouseClicked(null);
		}
	}
}

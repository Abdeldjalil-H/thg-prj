package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import app.UndirectedGraph;
public class Controller {
	@FXML
	private ToggleButton drawVertices;
	@FXML
	private ToggleButton drawEdges;
	@FXML
	private AnchorPane drawSpace;
	
	//private DrawVertex vertexDrawer = new DrawVertex();
	//private DrawEdge drawEdge;
	private UndirectedGraph graph;
	
	private GraphController<UndirectedGraph> some = new GraphController<UndirectedGraph>();
	public UndirectedGraph getGraph() {
		return graph;
	}


	public void setGraph(UndirectedGraph graph) {
		this.graph = graph;
	}


	public void enableDrawVerties(ActionEvent event) {
		
		if(drawVertices.isSelected()) {
			drawSpace.setOnMouseClicked(some.getDrawVertex());

		} else {
			drawSpace.setOnMouseClicked(null);
			drawVertices.getToggleGroup().selectToggle(null);

		}
	}
	
	public void enableDrawEdges(ActionEvent event) {
		if(drawEdges.isSelected()) {
			drawSpace.setOnMouseClicked(some.getDrawEdge());
		} else {
			drawSpace.setOnMouseClicked(null);
			drawEdges.setSelected(false);
		}
	}
}

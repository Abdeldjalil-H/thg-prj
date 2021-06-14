package gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DrawEdge implements EventHandler<MouseEvent>{
	private Vertex firstVertex; 
	private Vertex secondVertex;
	private boolean firstVertexSelected;
	
	@Override
	public void handle(MouseEvent event) {
		//we can add a check  if the clicked obj is Vertex
		if(!firstVertexSelected) {
			firstVertex = (Vertex)event.getSource();
			firstVertexSelected = true;
		} else {
			secondVertex = (Vertex)event.getSource();
			Edge edge = new Edge(firstVertex, secondVertex);
			
			firstVertexSelected = false;
			((AnchorPane) event.getSource()).getChildren().add(edge);
		}
	}

}

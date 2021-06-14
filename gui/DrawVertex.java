package gui;

import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DrawVertex implements EventHandler<MouseEvent>{
	
	@Override
	public void handle(MouseEvent event) {
		/*Vertex v = new Vertex( event.getSceneX(),
					event.getSceneY()
					);
		*/
		//((Group)((Scene) event.getSource()).getRoot()).getChildren().add(v);
		//((AnchorPane)((Scene) event.getSource()).getRoot()).getChildren().add(v);
		
		Point3D point = event.getPickResult().getIntersectedPoint();
		Vertex v = new Vertex(
							point.getX(),
							point.getY()
				);
		
		((AnchorPane) event.getSource()).getChildren().add(v);
		
	}

}

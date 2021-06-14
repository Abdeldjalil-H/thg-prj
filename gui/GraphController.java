package gui;

import app.Graph;
import app.UndirectedGraph;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GraphController<G extends Graph> {
	private DrawVertex drawVertex;
	private DrawEdge drawEdge;
	
	private G graph;
	
	{
		drawVertex = this.new DrawVertex();
		drawEdge = this.new DrawEdge();
		graph = (G) new UndirectedGraph();
	}

	public DrawVertex getDrawVertex() {
		return drawVertex;
	}


	public void setDrawVertex(DrawVertex drawVertex) {
		this.drawVertex = drawVertex;
	}

	public DrawEdge getDrawEdge() {
		return drawEdge;
	}

	public void setDrawEdge(DrawEdge drawEdge) {
		this.drawEdge = drawEdge;
	}

	public G getGraph() {
		return graph;
	}

	public void setGraph(G graph) {
		this.graph = graph;
	}
	
	private void addEdge(Edge edge) {
		graph.addNeighbor(
				edge.getFirstVertex(),
				edge.getSecondVertex()
				);
	}
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
			
			graph.addVertex(v);

		}

	}

	public class DrawEdge implements EventHandler<MouseEvent>{
		private Vertex firstVertex; 
		private Vertex secondVertex;
		private boolean firstVertexSelected;
		
		@Override
		public void handle(MouseEvent event) {
			Vertex v = null;
			if(event.getPickResult().getIntersectedNode() instanceof Vertex) {
				v = (Vertex)event.getPickResult().getIntersectedNode();
			} else if (event.getPickResult().getIntersectedNode()
					.getParent() instanceof Vertex) {
				v = (Vertex)event.getPickResult().getIntersectedNode().getParent();
			}
			if(v != null) {

				if(!firstVertexSelected) {
					
					firstVertex = v;
					firstVertexSelected = true;
					
				} else {
					secondVertex = v;
					Edge edge = new Edge(firstVertex, secondVertex);
		
					firstVertexSelected = false;
					addEdge(edge);
					((AnchorPane) event.getSource()).getChildren().add(edge);
				}
			} else {
				firstVertexSelected = false;
			}
		}

	}
	
}

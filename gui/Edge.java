package gui;

import javafx.scene.shape.Line;

public class Edge extends Line{
	private Vertex firstVertex; 
	private Vertex secondVertex;
	
	public Edge() {
	}
	public Edge(Vertex firstVertex, Vertex secondVertex) {
		super(
			firstVertex.getCenterX(),
			firstVertex.getCenterY(),
			secondVertex.getCenterX(),
			secondVertex.getCenterY()
		);
		this.setViewOrder(2);
		this.firstVertex = firstVertex;
		this.secondVertex = secondVertex;
	}
	public Vertex getFirstVertex() {
		return firstVertex;
	}
	public void setFirstVertex(Vertex firstVertex) {
		this.firstVertex = firstVertex;
	}
	public Vertex getSecondVertex() {
		return secondVertex;
	}
	public void setSecondVertex(Vertex secondVertex) {
		this.secondVertex = secondVertex;
	}
	
}

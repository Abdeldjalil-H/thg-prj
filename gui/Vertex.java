package gui;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Vertex extends Circle{
	static int id;
	
	private static final double RADIUS = 20;
	private static final double STROKE_WIDTH = 2;
	public ArrayList<Line> edges;
	
	static {
		id++;
	}
	
	public Vertex(double centerX, double centerY) {
		super(centerX, centerY, RADIUS, Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(STROKE_WIDTH);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	
	
}

package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Vertex extends Label{
	private static int idCounter;
	private int id;
	private static final double RADIUS = 34;
	private static final double DIAMETER = 2*RADIUS;
	private static final double STROKE_WIDTH = 2;
	public ArrayList<Line> edges;
	private double centerX;
	private double centerY;
	
	{
		id = idCounter++;
	}
	
	public Vertex() {
	}
	public Vertex(double centerX, double centerY) {
		super();
		
		 //TextField
		this.setWidth(DIAMETER);
		this.setHeight(DIAMETER);
		this.setMaxSize(DIAMETER,DIAMETER);
		this.setMinWidth(DIAMETER);
		this.setLayoutX(centerX-RADIUS);
		this.setLayoutY(centerY-RADIUS);
		this.setText(Integer.toString(id));
		this.setAlignment(Pos.CENTER);
		this.centerX = centerX;
		this.centerY = centerY;
		//this.setClip(new Circle(centerX, centerY, RADIUS));
		//*/
		/*
		Circle circle = new Circle(centerX, centerY, RADIUS, Color.WHITE);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(STROKE_WIDTH);
		
		*/
		
		/*Circle
		super(centerX, centerY, RADIUS, Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(STROKE_WIDTH);
		*/
		this.getStyleClass().add("vertex");
		
	}
	
	public double getCenterX() {
		return centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
}

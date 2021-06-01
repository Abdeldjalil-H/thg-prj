package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public abstract class Graph {
	private final int MAX_NUM_OF_VERTICES = 100;
	private final String EMPTY_VERTEX = "";
	private int firstEmptyPos;
	private int numberOfVertices;
	private String[] vertices;
	private ArrayList<Integer>[] adj;
	
	{
		vertices = new String[MAX_NUM_OF_VERTICES];
		//@SuppressWarnings("unchecked")
		adj = (ArrayList<Integer>[]) new ArrayList[MAX_NUM_OF_VERTICES];
	}
	public Graph(String[] vertices, int[][] adj) {
		System.arraycopy(vertices, 0, this.vertices, 
						0, vertices.length);
		
		numberOfVertices = vertices.length;
		
		for(int i=0; i<numberOfVertices; i++) {
			//convert int[] to Integer[] then to List
			this.adj[i] = (ArrayList<Integer>) IntStream.
					of(adj[i]).boxed().
					collect(Collectors.toList());
		}
	}
	
	public Graph() {
		
	}
	
	public int getIndex(String v) {
		for(int i=0; i < vertices.length; i++) {
			if(v.equals(vertices[i])) {
				return i;
			}
		}
		return -1;
	}
	
	private int getNextEmptyPos(int current) {
		while(! getVertex(current).equals(EMPTY_VERTEX)) {
			current++;
		}
		return current;
	}
	public String getVertex(int id) {
		if(id >= 0 && id < numberOfVertices) {
			return vertices[id];
		}
		return EMPTY_VERTEX;
	}
	
	//add a vertex and return true if added correctely
	public boolean addVertex(String v) {
		if(numberOfVertices < MAX_NUM_OF_VERTICES) {
			if(firstEmptyPos < MAX_NUM_OF_VERTICES) {
				vertices[firstEmptyPos++] = v;
				firstEmptyPos = getNextEmptyPos(firstEmptyPos);
			} else {
				vertices[numberOfVertices++] = v;
			}
			
			numberOfVertices++;
			return true;
		}
		return false;
	}
	
	public boolean addVertex(String v, int[] neighbors) {
		if(addVertex(v)) {
			int vIndex = getIndex(v);
			for(int neighbor: neighbors) {
				addNeighbor(vIndex, neighbor);
			}
			
			return true;
		}
		return false;
	}
	
	public void removeVertex(String v) {
		int vIndex = getIndex(v);
		vertices[vIndex] = EMPTY_VERTEX;
		numberOfVertices--;
		if(vIndex < firstEmptyPos) {
			firstEmptyPos = vIndex;
		}
		for(int neighbor: adj[vIndex]) {
			removeEdge(vIndex, neighbor);
		}
	}
	
	//add an existing neighbor to vertex v
	abstract public void addNeighbor(int vIndex, int neighborIndex);
	abstract public void addNeighbor(String v, String neighbor);
	
	abstract public void removeNeighbor(String v, String neighbor);
	
	
	abstract public void addEdge(String v1, String v2);
	
	abstract public void removeEdge(int v1Index, int v2Index);
	abstract public void removeEdge(String v1, String v2);
	
	public boolean areNeighbors(String v1, String v2) {
		int v2Index = getIndex(v2);
		for(int neighbor: adj[getIndex(v1)]) {
			if(v2Index == neighbor) {
				return true;
			}
		}
		return false;
	}
	
	public int[] getNeighbors(String v) {
		int index = getIndex(v);
		if(index != -1) {
			return adj[index].stream().mapToInt(i->i).toArray();
		} else {
			return new int[0];
		}
	}
	
}

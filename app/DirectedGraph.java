package app;

import gui.Vertex;
public abstract class DirectedGraph extends Graph {
	
	@Override
	public void addNeighbor(int vIndex, int neighborIndex) {
	
	    getAdj()[vIndex].add(neighborIndex)  ;
	
	}
	
	@Override
	public void addNeighbor(Vertex v, Vertex neighbor){
		int vIndex = getIndex(v);
		int IndexNeigh = getIndex(neighbor);
		addNeighbor(vIndex,IndexNeigh);
	}
	
	@Override
	public void removeNeighbor(Vertex v, Vertex neighbor){
		int vIndex=super.getIndex(v) ;
		//int IndexNeigh = super.getIndex(neighbor);
		getAdj()[vIndex].remove(neighbor);
	}
}
package app;
import java.util.ArrayList;

public abstract class DirectedGraph extends Graph {
	private ArrayList<Integer>[] ade = super.getAdj();
	
	@Override
	public void addNeighbor(int vIndex, int neighborIndex) {
	
	    ade[vIndex].add(neighborIndex)  ;
	
	}
	
	@Override
	public void addNeighbor(String v, String neighbor){
		int vIndex = getIndex(v);
		int IndexNeigh = getIndex(neighbor);
		addNeighbor(vIndex,IndexNeigh);
	}
	
	@Override
	public void removeNeighbor(String v, String neighbor){
		int vIndex=super.getIndex(v) ;
		int IndexNeigh=super.getIndex(neighbor);
		ade[vIndex].remove(neighbor);
	}
}
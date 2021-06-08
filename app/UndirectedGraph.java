package app;

import gui.Vertex;
public class UndirectedGraph extends Graph {
    @Override
    public void addNeighbor(int vIndex, int neighborIndex) {

        // v1 neighbor of v2
        super.getAdj()[vIndex].add(neighborIndex);

        //v2 neighbhor of v1 (because non-orienté)
        super.getAdj()[neighborIndex].add(vIndex);
    }

    @Override
    public void addNeighbor(Vertex v, Vertex neighbor) {
        int vIndex = super.getIndex(v);
        int neighborIndex= super.getIndex(neighbor);

        if((vIndex != -1) && (neighborIndex != -1))
        addNeighbor(vIndex, neighborIndex);
    }



    @Override
    public void removeNeighbor(int vIndex, int neighborIndex){
        super.getAdj()[vIndex].remove(neighborIndex);
        super.getAdj()[neighborIndex].remove(vIndex);

    }

    @Override
    public void removeNeighbor(Vertex v, Vertex neighbor) {
        int vIndex = super.getIndex(v);
        int neighborIndex= super.getIndex(neighbor);

        if((vIndex != -1) && (neighborIndex != -1))
        removeNeighbor(vIndex,neighborIndex);
    }

}

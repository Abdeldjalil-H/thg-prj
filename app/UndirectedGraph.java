package app;

public class UndirectedGraph extends Graph {
    @Override
    public void addNeighbor(int vIndex, int neighborIndex) {

        // v1 neighbor of v2
        super.getadj()[vIndex].add(neighborIndex);

        //v2 neighbhor of v1 (because non-orienté)
        super.getadj()[neighborIndex].add(vIndex);
    }

    @Override
    public void addNeighbor(String v, String neighbor) {
        int vIndex = super.getIndex(v);
        int neighborIndex= super.getIndex(neighbor);

        addNeighbor(vIndex, neighborIndex);
        //super.getadj()[vIndex].add(neighborIndex);
        //super.getadj()[neighborIndex].add(vIndex);
    }



    @Override
    public void removeNeighbor(int vIndex, int neighborIndex){

        super.getadj()[vIndex].remove(neighborIndex);
        super.getadj()[neighborIndex].remove(vIndex);

    }

    @Override
    public void removeNeighbor(String v, String neighbor) {
        int vIndex = super.getIndex(v);
        int neighborIndex= super.getIndex(neighbor);

        removeNeighbor(vIndex,neighborIndex);
        //super.getadj()[vIndex].remove(neighborIndex);
        //super.getadj()[neighborIndex].remove(vIndex);
    }

}

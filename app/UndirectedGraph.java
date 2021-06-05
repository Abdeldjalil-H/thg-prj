package app;

    import java.util.ArrayList ;

    public  class DirectedGraph extends Graph {

        @Override
        public void addNeighbor(int vIndex, int neighborIndex) {

            getAdj()[vIndex].add(neighborIndex)  ;

        }

        @Override
        public void addNeighbor(String v, String neighbor){
            int vIndex = getIndex(v);
            int IndexNeigh = getIndex(neighbor);
            addNeighbor(vIndex,IndexNeigh);
        }

        @Override
        public void removeNeighbor(int vIndex, int neighborIndex) {
            
        }

        @Override
        public void removeNeighbor(String v, String neighbor){
            int vIndex=super.getIndex(v) ;
            int IndexNeigh=super.getIndex(neighbor);
            getAdj()[vIndex].remove(IndexNeigh);
        }
    }


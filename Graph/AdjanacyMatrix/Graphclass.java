// import Graph;

class Graphclass{    
    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(3,2);
        g.addEdge(2,4);
        g.addEdge(1,4);
        g.addEdge(3,1);
        g.addEdge(2,0);
        g.printGraph();
    }
}
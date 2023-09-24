import java.io.*;
import java.util.*;

class Graph{
    ArrayList<ArrayList<Integer>> graph;
    int V;

    Graph(int nodes){
        V = nodes;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<Integer>());
        } 
    }

    void addEdge(int v,int u){
        graph.get(v).add(u);
        graph.get(u).add(v);
    }

    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print("Node :" + i);
            for(int val : graph.get(i)){
                System.out.print(" -> " + val);
            }
            System.out.println();
        }
    }
}
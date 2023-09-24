import java.io.*;
import java.util.*;

class Graph{
    int[][] graph;
    int V;

    Graph(int nodes){
        V = nodes;
        graph = new int[V][V];
    }

    void addEdge(int v,int u){
        graph[v][u] = 1;
        graph[u][v] = 1;
    }

    void printGraph(){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}   
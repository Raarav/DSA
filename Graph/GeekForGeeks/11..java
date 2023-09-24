// Q->https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
// Q->Count all possible Paths between two Vertices

import java.util.*;
import java.io.*;

public class Main
{
    private int V;
    private LinkedList<Integer> adj[];
    
    Main(int val){
        V = val;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w); 
    }
    
    void display(){
        for(int i=0;i<V;i++){
            System.out.print(i + "->");
            LinkedList<Integer> al = adj[i];
            for(int j=0;j<al.size();j++){
                System.out.print(al.get(j) + ", ");
            }
            System.out.println(".");
        }
    }
    
    private int countPaths(int s,int d){
        LinkedList<Integer> nbr = adj[s];
        if(s == d) return 1;
        if(nbr.size() == 0) return 0;
        int count = 0;
        for(int i=0;i<nbr.size();i++){
            int start = nbr.get(i);
            count += countPaths(start, d);
        }
        return count;
    }

	public static void main(String[] args) {
	    
        Main g = new Main(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        
        int s = 0, d = 3;
        // g.display();
        
        // function call
        System.out.println(g.countPaths(s, d));
	}
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

// *******************************************************************************/
// Q->https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/


import java.util.*;
import java.io.*;

public class Main
{
    static int N = 3;
    static int M = 4;
    
    static void printDistance(int mat[][]){
        int ans[][] = new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        

        //Naive Approach
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    for(int l=0;l<M;l++){
                        
                        if(mat[k][l] == 1){
                            ans[i][j] = Math.min(ans[i][j], Math.abs(i-k) + Math.abs(j-l));
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		int mat[][] = {{0,0,0,1},{0,0,1,1},{0,1,1,0}};
		printDistance(mat);
	}
}

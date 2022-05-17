// Q -> 1219. Path with Maximum Gold ( https://leetcode.com/problems/path-with-maximum-gold/ )
// or
// Q -> https://www.geeksforgeeks.org/gold-mine-problem/

import java.util.*;
import java.io.*;
class n2_path_with_maximum_gold{
    private static int max(int a,int b,int c){
        return a > b ? (a > c ? a : c) : (b > c ? b : c) ;        
    }
    private static int recursive(int[][] arr, int row,int col,int m,int n){
        
        if(row >= m || row < 0) return Integer.MIN_VALUE;
        if(col >= n || col < 0) return Integer.MIN_VALUE;
        if(col == n-1) return arr[row][col];

        int up = recursive(arr, row - 1, col + 1, m, n);
        int right = recursive(arr, row, col + 1, m, n);
        int down = recursive(arr, row + 1, col + 1, m, n);   

        return arr[row][col] + max(up,right,down);     
    } 

    private static int dpmemo(int[][] arr,int row,int col,int m,int n, int[][] dp){
        if(row >= m || row < 0) return Integer.MIN_VALUE;
        if(col >= n || col < 0) return Integer.MIN_VALUE;
        if(col == n-1) return arr[row][col];

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        int up = recursive(arr, row - 1, col + 1, m, n);
        int right = recursive(arr, row, col + 1, m, n);
        int down = recursive(arr, row + 1, col + 1, m, n);   

        return dp[row][col] = arr[row][col] + max(up,right,down);
    }

    private static int bottom_up(int[][] arr,int m,int n,int[][] dp){
        
        //last column filling
        for(int i=0;i<m;i++){
            dp[i][n-1]=arr[i][n-1];
            // System.out.print( "last col -> " + dp[i][n-1] + ", ");
        }    

        //  System.out.println();  

        for(int j=n-2;j>=0;j--){
            for(int i=0;i<m;i++){
                int up = Integer.MIN_VALUE;
                if(i-1>=0){
                    up = arr[i][j] + dp[i-1][j+1];
                }
                int right = arr[i][j] + dp[i][j+1];
                int down = Integer.MIN_VALUE;
                if(i+1<m){
                    down = arr[i][j] + dp[i+1][j+1];
                }
                dp[i][j] = max(up,right,down); 
                // System.out.print( "rest col -> " + "i,j" + "->" + i + "," + j + "->" + up + "," + right + "," + down + "," + dp[i][j] + ", ");             
            }
            // System.out.println();
        } 

        int result = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            result = Math.max(result,dp[i][0]);
            // System.out.print( "result col -> " + dp[i][0] + ", ");
        }
        // System.out.println();
        return result;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                arr[row][col]=scn.nextInt();
            }
        }

        int result = 0;
        // for(int row=0;row<m;row++){
        //     result = Math.max(result,recursive(arr,row,0,m,n));
        // }

        // dp 
        int[][] dp = new int[m][n];
        
        // memoziation
        // for(int row=0;row<m;row++){
        //     result = Math.max(result,dpmemo(arr,row,0,m,n,dp));
        // }

        // bottom up
        result = bottom_up(arr,m,n,dp);
        

        System.out.println(result);
    }
}
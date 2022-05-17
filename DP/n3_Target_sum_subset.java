// Q -> https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

import java.util.*;
import java.io.*;

class n3_Target_sum_subset{
    private static boolean recursive(int[] arr,int n,int tr){
        if(tr == 0) return true;
        if(tr < 0 || n==arr.length) return false;

        return recursive(arr,n+1,tr) || recursive(arr,n+1,tr-arr[n]);
    }

    private static boolean Top_down(int[] arr, boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }

        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=false;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean upperResult = dp[i-1][j];
                boolean currentIndexResult = false;
                if(upperResult == false){
                    int preJ = j - arr[i-1];
                    if(preJ>=0){
                        currentIndexResult = dp[i-1][preJ];                         
                    }                    
                }

                dp[i][j] = upperResult || currentIndexResult;               
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i]=scn.nextInt();
        }
        int tr = scn.nextInt();
        boolean result = false;
        
        // result = recursive(arr,0,tr);

        //dp
        boolean[][] dp = new boolean[size+1][tr+1];
        
        //memo
        result = Top_down(arr, dp);
        
        System.out.print(result);
    }
}
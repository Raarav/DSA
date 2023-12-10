// Q-https://www.desiqna.in/dynamic-programming
import java.util.*;
import java.io.*;

class Set1{
    public static void main(String[] arg){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int q = scn.nextInt();
        int qry[] = new int[q];
        for(int i=0;i<q;i++){
            qry[i] = scn.nextInt();
        }

        int[] dp = new int[n+1];

        for(int i=0;i<n;i++){
            if(i==0) dp[i] = arr[i];
            else{
            dp[i] = dp[i-1] + arr[i];}
        }

        for(int i=0;i<q;i++){
            System.out.println(dp[qry[i]]);
        }
    }
}
// Q->https://atcoder.jp/contests/dp/tasks/dp_c

import java.util.*;
import java.io.*;

class Main{
  public static void main(String[] arg){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][3];
    
    for(int i=0;i<n;i++){
      for(int j=0;j<3;j++){
        arr[i][j] = scn.nextInt();
      }
    }
    
    int[][] dp = new int[n+1][3];
    
    for(int i=1;i<=n;i++){
      dp[i][0] = arr[i-1][0] + Math.max(dp[i-1][1], dp[i-1][2]);
      dp[i][1] = arr[i-1][1] + Math.max(dp[i-1][0], dp[i-1][2]);
      dp[i][2] = arr[i-1][2] + Math.max(dp[i-1][0], dp[i-1][1]);
    }
    
    System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
  }
}
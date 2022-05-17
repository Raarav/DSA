// Q -> https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

// for recursive aprroch TC is O(2^n) and SC is O(1)

import java.util.*;
import java.io.*;

class 0_Zero_1_knapsac{

    private static int knapsack(int[] wt,int[] val,int w,int n){
        
        if(n == 0|| w == 0) return 0;
        
        if(wt[n-1] > w) return knapsack(wt,val,w,n-1);
        else return Math.max(val[n-1] + knapsack(wt-wt[n-1],val,w,n-1), knapsack(wt,val,w,n-1));
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] val = new int[size];
        int[] wt = new int[size];  //  wt weight of val 

        for(int i=0;i<size;i++){
            wt[i] = scn.nextInt();
        }  
        for(int i=0;i<size;i++){
            val[i] = scn.nextInt();
        }

        int W = scn.nextInt();   // W means weight of beg capacity

        System.out.println(knapsack(wt, val, W, size));
    }
}
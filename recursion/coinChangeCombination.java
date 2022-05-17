// https://www.youtube.com/watch?v=ZiwJdiSGXB4

// Q->Coin Change Problem - Recursion - Part 1 and 2;

import java.util.*;
import java.io.*;

class coinChangeCombination{
    private static int recursiveUnlimitedSupply(int[] coins,int target,int index,int amount){
        if(index == coins.length){
            
        }
        int result 
        for(int amount / coins[i]; j >= 1; j--){
            recursiveUnlimitedSupply(coins,target,index+1,amount + coins[index] * j);                        
        }      
        recursiveUnlimitedSupply(coins,target,index+1,amount);
    }
    // for not unlimited supply
    private static boolean recursive(int[] coins,int target,int index){
        if(target == 0) return true; 
        if(target < 0 || index == coins.length) return false;
        return recursive(coins, target, index+1) || 
        recursive(coins, target - coins[index], index+1);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] coins = new int[size];
        for(int i=0;i<size;i++){
            coins[i]=scn.nextInt();
        }
        int target = scn.nextInt();

        // for not unlimited supply
        boolean result = recursive(coins,target,0);

        // for unlimited supply
        boolean result = recursiveUnlimitedSupply(coins,target,0,0);

        System.out.print(result);
    }
}
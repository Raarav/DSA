// Q->https://leetcode.com/problems/coin-change-ii/description/
// S->https://leetcode.com/problems/coin-change-ii/solutions/2675878/easy-pick-not-pick-java-solution-recursion-to-tabualtion/


class Solution {
    // Recursion
//     public int change(int amount, int[] coins) {
//         return helper(coins , amount , coins.length-1);
//     }
    
//     private int helper(int[] coins , int amount, int i) {
//         if(amount == 0) return 1;
        
//         if(i == 0){
//             if(amount % coins[0] == 0) return 1;
//             else return 0;
//         } 
        
//         int pick = 0;
//         if(amount >= coins[i]){
//             pick = helper(coins , amount - coins[i] , i);
//         }
        
//         int notPick = helper(coins , amount , i-1);
        
//         return pick + notPick;
//     }
    // MEMOIZATION
    
    /*public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length][amount+1] ;
        for(int i=0 ; i<coins.length ; i++){
            Arrays.fill ( dp[i] , -1);
        }
        
        return helper(coins , amount , coins.length-1 , dp);
    }
    
    private int helper(int[] coins , int amount, int i , int[][] dp) {
        if(amount == 0) return 1;
        
        if(i == 0){
            if(amount % coins[0] == 0) return 1;
            else return 0;
        } 
        
        if(dp[i][amount] != -1) return dp[i][amount];
        
        int pick = 0;
        if(amount >= coins[i]){
            pick = helper(coins , amount - coins[i] , i , dp);
        }
        
        int notPick = helper(coins , amount , i-1 , dp);
        
        dp[i][amount] = pick + notPick;
        
        return dp[i][amount];
    }
    */
    
    // TABULATION
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1] ;
        for(int i=0 ; i<coins.length ; i++){
            dp[i][0] = 1;
        }
        
        for(int j=0 ; j<=amount ; j++){
            if(j % coins[0] == 0) dp[0][j] = 1;
            else dp[0][j] = 0;
        }
        
        for(int i=1 ; i<n ; i++){
             for(int amt=1 ; amt<=amount ; amt++){
                 int notTake = dp[i-1][amt];
                 
                 int take = 0;
                 if(amt >= coins[i]){
                     take = dp[i][amt-coins[i]] ;
                 }

                 dp[i][amt] =  (take + notTake);
             }
         }
                    
        return dp[n-1][amount];
        
    }    
    
}
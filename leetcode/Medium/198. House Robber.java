// Q->https://leetcode.com/problems/house-robber/
// S->https://leetcode.com/problems/house-robber/discuss/2860228/JAVA-Total-Four-(4)-approaches-Brute-Force-to-Optimized-Solution.
// V->https://www.youtube.com/watch?v=pchOMyPbp0I

class Solution {
    static int solve(int i, int[] arr, int n, int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(arr[i]+solve(i+2, arr, n, dp), solve(i+1, arr, n, dp));
    }
    
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        
        if(n==0) return 0;
        else if(n==1) return nums[0];
        return solve(0, nums, n, dp);
    }
}


//mine 
class Solution {
    private int recur(int[] nums, int n){
        if(n >= nums.length) return 0;
        
        int include = nums[n] + recur(nums, n+2);
        int exclude = recur(nums, n+1);
        
        return Math.max(include, exclude);
    }
    private int Memo(int[] nums, int n, int[] dp){
        if(n >= nums.length) return 0;
        
        if(dp[n]!=0) return dp[n];
        int include = nums[n] + Memo(nums, n+2, dp);
        int exclude = Memo(nums, n+1, dp);
        dp[n] = Math.max(include, exclude);
        return dp[n];
    }    
    public int rob(int[] nums) {
        // return recur(nums, 0);
        return Memo(nums, 0, new int[nums.length]);
    }
}
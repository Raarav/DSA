// Q->https://leetcode.com/problems/jump-game/
// S->https://www.youtube.com/watch?v=muDPTDrpS28


class Solution {
    private boolean canJump(int[] nums, int n){
        if(n == nums.length-1) return true;
        if(n >= nums.length) return false;
        
        for(int i=1;i<=nums[n];i++){
            boolean flag = canJump(nums, n + i);
            if(flag)
                return true;
        }
        
        return false;
    }
    private boolean Tab(int[] nums, int n, boolean[] dp){
        if(n == nums.length-1) return true;
        if(n >= nums.length) return false;
        
        if(dp[n]) return dp[n];
        
        boolean flag = false;
        for(int i=1;i<=nums[n];i++){
            flag = Tab(nums, n + i, dp);
            if(flag) return dp[n] = true;           
        }
        
        return dp[n] = flag;     
    }
    public boolean canJump(int[] nums) { 
        //my solution gives TLE 
        // return canJump(nums, 0);
        // return Tab(nums, 0, new boolean[nums.length]);
        
        //optimise this solution is working
        int maxIndex = nums.length-1;
        int maxJump  = nums[0];
        for(int i = 0; i <= maxJump; i++){
            maxJump=Math.max(maxJump,i+nums[i]);
            if(maxJump>=maxIndex) return true;
        }
        return false;
        
        
    }
}
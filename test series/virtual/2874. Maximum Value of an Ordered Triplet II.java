// Q->https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-ii/
// S->https://www.youtube.com/watch?v=lDMsLjX2VL4

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int maxi = Math.max(nums[0], nums[1]);
        long maxDiff = (long)(nums[0] - nums[1]);
        for(int k=2;k<n;k++){
            long val = (long)(maxDiff*nums[k]);
            if(val > ans){
                ans = val;
            }
            maxDiff = (long)Math.max(maxDiff, maxi - nums[k]);
            maxi = Math.max(maxi, nums[k]);
        }
        return ans;
    }
}
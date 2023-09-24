// Q->https://leetcode.com/contest/weekly-contest-312/problems/longest-subarray-with-maximum-bitwise-and/
// S->https://www.youtube.com/watch?v=4Ljd4kiynAI

class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }        
        
        int count = 0;
        int ans = 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == max){
                count++;
            }else{
                count=0;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
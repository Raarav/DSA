// Q->https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length == 0) return result;
        int start = 0;
        int end = nums.length;
        
        while(start<end){
            if(target == nums[start]){
                result[0] = start;
                break;                
            }
            start++;
        }
        
        while(start<end){
            end--;
            if(target == nums[end]){
                result[1] = end;
                break;                
            }
        }
        return result;
    }
}
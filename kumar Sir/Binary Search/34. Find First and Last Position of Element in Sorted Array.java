Q->https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;        
    }

    private int findFirst(int[] nums, int tar){
        int start = 0;
        int end = nums.length - 1;
        int id = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == tar){
                id = mid;
                end = mid-1;
            }else if(nums[mid] >= tar){
                end = mid-1;
            }else{
               start = mid + 1;
            }
        }
        return id;
    }

    private int findLast(int[] nums, int tar){
        int start = 0;
        int end = nums.length - 1;
        int id = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == tar){
                id = mid;
                start = mid + 1;
            }else if(nums[mid] > tar){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return id;
    }
}
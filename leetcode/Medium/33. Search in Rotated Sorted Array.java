// Q->https://leetcode.com/problems/search-in-rotated-sorted-array/
// S->https://www.youtube.com/watch?v=1uu3g_uu8O0

class Solution {
    private int binarySearch(int left, int right, int[] nums, int target){
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] <= nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }
}
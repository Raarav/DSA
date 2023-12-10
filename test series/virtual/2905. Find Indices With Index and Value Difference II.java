// Q->https://leetcode.com/contest/weekly-contest-367/problems/find-indices-with-index-and-value-difference-ii/
// S->https://www.youtube.com/watch?v=zGbpYmwtdRs
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int mini = 0;
        int maxi = 0;
        int[] res = {-1, -1};
        for(int i=indexDifference;i<n;i++){
            
            if(nums[i-indexDifference] < nums[mini]) mini = i - indexDifference;
            
            if(nums[i - indexDifference] > nums[maxi]) maxi = i - indexDifference;
            
            if(Math.abs(nums[mini] - nums[i]) >= valueDifference){ 
                res[0] = mini;
                res[1] = i;
                break;
            }
            if(Math.abs(nums[maxi] - nums[i]) >= valueDifference){
                res[0] = maxi;
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
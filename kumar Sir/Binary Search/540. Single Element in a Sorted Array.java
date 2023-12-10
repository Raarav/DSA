// Q->https://leetcode.com/problems/single-element-in-a-sorted-array/description/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if(r==0) return nums[0];
        else if(nums[0] != nums[1]) return nums[0];
        else if(nums[r] != nums[r-1]) return nums[r];
        
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] != nums[m+1] && nums[m] != nums[m-1]) return nums[m];
            else if(nums[m] == nums[m-1]){
                if((m-1)%2 == 1){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(nums[m] == nums[m+1]){
                if(m%2 == 1){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }    
        return -1;    
    }
}
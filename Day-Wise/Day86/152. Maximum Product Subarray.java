Q->https://leetcode.com/problems/maximum-product-subarray/description/



class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        for(int val : nums){
            product *= val;
            max = Math.max(product, max);
            if(val == 0){
                product = 1;
            }           
        }
        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            int val = nums[i];
            product *= val;
            max = Math.max(product, max);
            if(val == 0){
                product = 1;
            }          
        }
        return max;
    }
}
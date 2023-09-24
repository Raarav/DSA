// Q->https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if(size == 1) return nums[0];
        int max = -1*(int)Math.pow(10,4);
        int sum = 0;
        for(int i=0;i<size;i++){
            sum += nums[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}

// dp solution
// s->https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
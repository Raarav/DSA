// Q->https://leetcode.com/problems/maximum-product-subarray/
// S->https://www.youtube.com/watch?v=GbJh0MjUa5U
// S->https://leetcode.com/problems/maximum-product-subarray/discuss/183483/JavaC%2B%2BPython-it-can-be-more-simple
//  O(1) space, O(n) running time
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


// optimised code
public int maxProduct(int[] A) {
    int n = A.length, res = A[0], l = 0, r = 0;
    for (int i = 0; i < n; i++) {
        l =  (l == 0 ? 1 : l) * A[i];
        r =  (r == 0 ? 1 : r) * A[n - 1 - i];
        res = Math.max(res, Math.max(l, r));
    }
    return res;
}


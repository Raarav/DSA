// Q->https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description
// V->https://www.youtube.com/watch?v=ho9x_C2akHg
// V->https://www.youtube.com/watch?v=GvAtQOMr8CQ


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int i = 0;
        int max = Integer.MIN_VALUE;;
        for(;i<n;){
            max = Math.max(max, nums[i]);
            left[i] = max;
            i++;
        }   
        int[] right = new int[n]; 
        i=n-1;
        int min = Integer.MAX_VALUE;
        for(;i>=0;){
            min = Math.min(min, nums[i]);
            right[i] = min;
            i--;
        } 

        int l = 0;
        for(;l<n;){
            if(left[l]!=right[l])
                break;
            l++;
        }

        if(l==n) return 0;
        int r = n-1;
        for(;r>=0;){
            if(left[r]!=right[r])
                break;
            r--;
        }
              
        return r - l + 1;
    }
}
```
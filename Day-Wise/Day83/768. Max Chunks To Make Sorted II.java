// Q->https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
// V->https://www.youtube.com/watch?v=GxTo3agdnjs

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
    public int maxChunksToSorted(int[] arr) {
        // 1. generate right min
        int[] rmin = new int[arr.length + 1];

        rmin[arr.length] = Integer.MAX_VALUE;
        for(int i=arr.length - 1;i>=0;i--){
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }

        // 2. iterate on array and manage leftrt max as well as count chunks
        int leftMax = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0;i<arr.length;i++){
            leftMax = Math.max(leftMax, arr[i]);
            if(leftMax <= rmin[i+1]){
                count++;
            }
        }
        return count;
    }
}
```
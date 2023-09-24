// Q->https://leetcode.com/problems/max-chunks-to-make-sorted/
// V->https://www.youtube.com/watch?v=Aor_z1iryc4

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunk = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(max == i){
                chunk++;
            }
        }        
        return chunk;
    }
}
```
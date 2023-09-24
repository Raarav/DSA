Q->https://leetcode.com/problems/find-peak-element/description/


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Three pointer approch 

# Approach 
<!-- Describe your approach to solving the problem. -->
comparition and iterate to all element 

# Complexity
- Time complexity: o(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        else if(n == 2) return nums[1] > nums[0] ? 1 : 0;    
        else{
            int pre = -2;
            int cur = -1;
            int post = 0;
            while(post!=n){
                if(pre >= 0 && cur >= 0 && post < n && nums[pre] < nums[cur] && nums[cur] > nums[post]){
                    return cur;
                }
                pre++;
                cur++;
                post++;
            }    
            if(nums[pre] < nums[cur]){
                return cur;
            } else {
                return 0;
            }            
        }    
    }
}
```
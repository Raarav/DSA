// Q->https://leetcode.com/problems/largest-rectangle-in-histogram/description/

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
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n]; // store right small element index
        int[] left = new int[n]; // store left small element index  
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        for(int i=n-1;i>=0;i--){
            while(stack.peek() != n && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }   
        stack = new Stack();
        stack.push(-1);

        for(int i=0;i<n;i++){
            while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        } 

        int result = 0;

        for(int i=0;i<n;i++){
            result = Math.max(result, heights[i]*(right[i] - left[i] -1));
        }
        return result;
    }
}
```
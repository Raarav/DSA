// Q->https://leetcode.com/problems/container-with-most-water/
// S->https://www.youtube.com/watch?v=ZHQg07n_tbg

class Solution {
    public int maxArea(int[] height) {
        //mine,,,, solution belong to next greater element
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length-1;
        while(start < end){
            int left = height[start];
            int right = height[end];
            int min = Math.min(left, right);
            max = Math.max(max, min*(end-start));
            if(left < right) start++;
            else end--;
        }
        return max;
    }
}
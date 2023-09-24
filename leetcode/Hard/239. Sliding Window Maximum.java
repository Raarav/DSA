// Q->https://leetcode.com/problems/sliding-window-maximum/
// S->https://www.youtube.com/watch?v=tCVOQX3lWeI
// all Solutions // S->https://leetcode.com/problems/sliding-window-maximum/discuss/458121/Java-All-Solutions-(B-F-PQ-Deque-DP)-with-Explanation-and-Complexity-Analysis

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        stack.push(n-1);
        nge[n-1] = n;
        for(int i=n-2;i>=0;i--){
            while(stack.size() > 0 && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            if(stack.size() == 0){
                nge[i] = n;
            }else{
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        int[] result = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            if(i+k-1 < nge[i]){
                result[i] = nums[i];
            }else{
                int j = nge[i];
                while(i+k > nge[j]){
                    j = nge[j];
                }
                result[i] = nums[j];
            }
        }
        return result;
    }
}
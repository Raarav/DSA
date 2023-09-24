// https://leetcode.com/problems/daily-temperatures/description/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();
        while(--n>=0){
            while(!stack.isEmpty() && temperatures[n] >= temperatures[stack.peek()]){
                stack.pop();                
            }
            res[n] = stack.isEmpty() ? 0 : stack.peek() - n; 
            stack.push(n);
        }
        return res;
    }
}
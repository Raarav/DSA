// Q->https://leetcode.com/problems/evaluate-reverse-polish-notation/
// another Solution:-> https://leetcode.com/problems/evaluate-reverse-polish-notation/discuss/2766705/5-ms-faster-than-97.40-java


class Solution {
    private boolean check(String str){
        return str.equals("*") || 
            str.equals("/") || 
            str.equals("-") || 
            str.equals("+") 
            ? true : false; 
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){            
            if(check(str)){
                int b = stack.pop();
                int a = stack.pop();
                if(str.equals("/"))
                    stack.push(a / b);
                if(str.equals("*"))
                    stack.push(a * b);
                if(str.equals("+"))
                    stack.push(a + b);
                if(str.equals("-"))
                    stack.push(a - b);
            }else{
                int val = Integer.parseInt(str);
                stack.push(val);
            }
        }
        return stack.pop();
        
    }
}
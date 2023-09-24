// Q->https://leetcode.com/problems/basic-calculator-ii/
// S->https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution


class Solution {
    public int calculate(String s) {        
        Stack<Integer> stack = new Stack<>();
        s += '+';
        int len = s.length();
        char op = '+';
        for(int i=0, n=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') { n=n*10 + ch - '0'; continue; }
            if(ch == ' ') continue;
            if(op == '+') stack.push(n);
            else if(op == '-') stack.push(-n);
            else if(op == '*') stack.push(stack.pop()*n);
            else if(op == '/') stack.push(stack.pop()/n);
            op=ch;
            n=0;
        }
        
        int total = 0;
        while(!stack.empty()) total += stack.pop();
        return total;
    }
}
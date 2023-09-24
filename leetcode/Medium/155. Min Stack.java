// Q->https://leetcode.com/problems/min-stack/description/x 

// using stack in java
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


//mine
class MinStack {
    int val;
    ArrayList<Integer> al;
    public MinStack() {
        val = 0;
        al = new ArrayList<>();
    }
    
    public void push(int val) {
        al.add(val);
    }
    
    public void pop() {
        al.remove(al.size()-1);
    }
    
    public int top() {
        return al.get(al.size()-1);        
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<al.size();i++){
            min = Math.min(al.get(i), min);
        }        
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
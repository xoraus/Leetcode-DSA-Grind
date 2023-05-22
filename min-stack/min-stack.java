// Approach 1

class MinStack {
    Stack<Integer> min, stk;

    public MinStack() {
        min = new Stack<>();
        stk = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stk.push(val);
        min.push(Math.min(val, min.peek()));
    }
    
    public void pop() {
        stk.pop();
        min.pop();
    }
    
    public int top() {
        return stk.peek();    
    }
    
    public int getMin() {
        return min.peek();
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
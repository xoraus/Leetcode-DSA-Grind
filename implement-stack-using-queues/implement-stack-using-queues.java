// Appraoch 2: Push heavy - Pop Efficient

class MyStack {
    Queue<Integer> q = new ArrayDeque<>();
    
    public void push(int x) {
        q.add(x);
        for(int idx = 0; idx < q.size() - 1; idx++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
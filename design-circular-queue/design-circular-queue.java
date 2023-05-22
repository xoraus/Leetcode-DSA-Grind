class MyCircularQueue {
    int[] arr;
    int front = 0, rear = 0, size = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false; // Queue Overflow

        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false; // Queue Underflow

        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        // (rear - 1 + n) % n
        return arr[(rear - 1 + arr.length) % arr.length];
    }
    
    public boolean isEmpty() {
        return (size == 0);
        
    }
    
    public boolean isFull() {
        return (size == arr.length);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
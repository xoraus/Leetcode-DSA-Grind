//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends

// class StackNode {
//     int data;
//     StackNode next;
//     StackNode(int a) {
//         data = a;
//         next = null;
//     }
// } 

class MyStack {
  
    StackNode head;
    
    //Function to push an integer into the stack.
    void push(int value) {
        StackNode node = new StackNode(value);
        node.next = head;
        head = node;
    }
    
    //Function to remove an item from top of the stack.
    int pop() {
        if(head == null) {
            return -1;
        }
        
        int ans = head.data;
        head = head.next;
        return ans;
    }
}

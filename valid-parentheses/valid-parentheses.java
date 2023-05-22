// Time = O(N), Space = O(N)

class Solution {
    public boolean isValid(String S) {
        Stack<Character> stk = new Stack<>();
        
        for (int idx = 0; idx < S.length(); idx++) {
            char ch = S.charAt(idx);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else {
                if (stk.size() == 0) {
                    return false; // extra closing
                }
                
                if (ch == ')' && stk.peek() == '(') {
                    stk.pop();
                } else if (ch == '}' && stk.peek() == '{') {
                    stk.pop();
                } else if (ch == ']' && stk.peek() == '[') {
                    stk.pop();
                } else {
                    return false; // type or order mismatch
                }
            }
        }
        
        return (stk.size() == 0); // stk.size() > 0: extra open
    }
}
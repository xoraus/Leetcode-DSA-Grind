class Solution {
    public void remove(String input, int idx, StringBuilder output){
        if(idx == input.length()) return;
        char ch = input.charAt(idx);

        if(output.length() > 0 && output.charAt(output.length() - 1) == ch){
            // adjacent duplicates -> deleted
            output.deleteCharAt(output.length() - 1);
        } else output.append(ch);
            
        remove(input, idx + 1, output);
    }
    
    public String removeDuplicates(String s) {

        // Recurisve Approach

            // StringBuilder output = new StringBuilder();
            // remove(s, 0, output);
            // return output.toString();

        // Iterative Approach

        Stack<Character> st = new Stack<>();

        for (int idx = 0; idx < s.length(); idx++) {
            Character ch = s.charAt(idx);
            if (st.isEmpty() || ch != st.peek()) {
                st.push(ch);
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();        
    }
}

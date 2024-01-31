class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[arr.length];

        for(int idx = arr.length -1; idx >= 0; idx--){
            while(stk.size() >0 && arr[stk.peek()] <= arr[idx]){
                stk.pop();
            }

            res[idx] = (stk.size() > 0) ? stk.peek() - idx : 0;
            stk.push(idx);
        }

        return res;
    }
}
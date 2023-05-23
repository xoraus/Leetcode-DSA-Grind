class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] nextGreaterElement = new int[n];
        Arrays.fill(nextGreaterElement, -1);
        
        for (int idx = 0; idx < 2 * n; idx++) {
            int circularIdx = idx % n;
            
            while (stk.size() > 0 && nums[circularIdx] > nums[stk.peek()]) {
                nextGreaterElement[stk.pop()] = nums[circularIdx];
            }
            
            if (idx < n) {
                stk.push(circularIdx);
            }
        }

        return nextGreaterElement;
    }
}
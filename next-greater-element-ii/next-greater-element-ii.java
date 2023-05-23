class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] nextGreaterElement = new int[n];
        Arrays.fill(nextGreaterElement, -1);
        
        for(int idx = 0; idx < n; idx++){
            while(stk.size() > 0 && nums[idx] > nums[stk.peek()]){
                nextGreaterElement[stk.pop()] = nums[idx];
            }
            stk.push(idx);
        }

        for(int idx = 0; idx < n; idx++){
            while(stk.size() > 0 && nums[idx] > nums[stk.peek()]){
                nextGreaterElement[stk.pop()] = nums[idx];
            }
        }

        return nextGreaterElement;
    }
}
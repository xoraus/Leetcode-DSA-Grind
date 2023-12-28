class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater elements for each element in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        // Find next greater elements for each element in nums2
        int[] nextGreaterArr = findNextLargerElements(nums2, nums2.length);

        // Populate the map with the results
        for (int i = 0; i < nums2.length; i++) {
            nextGreaterMap.put(nums2[i], nextGreaterArr[i]);
        }

        // Prepare the result array based on nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = (int) nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static int[] findNextLargerElements(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {
            while (!stack.isEmpty() && arr[idx] >= stack.peek()) {
                stack.pop(); // Pop smaller or equal elements
            }
            result[idx] = (!stack.isEmpty()) ? stack.peek() : -1;
            stack.push(arr[idx]); // Push current element to the stack
        }

        return result;
    }
}
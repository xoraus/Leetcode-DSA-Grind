class Solution {
    public void nextPermutation(int[] array) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : array) nums.add(num);

        int n = nums.size(); // size of the array.

        // Step 1: Find the break point:
        int breakPoint = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                // index i is the break point
                breakPoint = i;
                break;
            }
        }

        // If break point does not exist:
        if (breakPoint == -1) {
            // reverse the whole array:
            Collections.reverse(nums);
            for (int idx = 0; idx < n; idx++) {
                array[idx] = nums.get(idx);
            }
            return;
        }

        // Step 2: Find the next greater element
        //         and swap it with nums[breakPoint]:
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums.get(i) > nums.get(breakPoint)) {
                int tmp = nums.get(i);
                nums.set(i, nums.get(breakPoint));
                nums.set(breakPoint, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = nums.subList(breakPoint + 1, n);
        Collections.reverse(sublist);

        for (int idx = 0; idx < n; idx++) {
            array[idx] = nums.get(idx);
        }
    }
}
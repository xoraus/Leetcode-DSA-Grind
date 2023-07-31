class Solution {
    public int longestConsecutive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : A) {
            set.add(num);
        }
        int max = 0;
        for (int num : A) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
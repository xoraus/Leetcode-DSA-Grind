class Solution {
    public static int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];

        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        Arrays.sort(taskCounts);

        int maxCount = taskCounts[25] - 1;
        int idleSlots = maxCount * n;

        for (int i = 24; i >= 0 && taskCounts[i] > 0; i--) {
            idleSlots -= Math.min(taskCounts[i], maxCount);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
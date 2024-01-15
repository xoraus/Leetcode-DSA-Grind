import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lost = new HashMap<>();

        for (int[] match : matches) {
            int lose = match[1];
            lost.put(lose, lost.getOrDefault(lose, 0) + 1);
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int[] match : matches) {
            int lose = match[1];
            int win = match[0];

            if (lost.get(lose) == 1) oneLoss.add(lose);
            if (!lost.containsKey(win)) {
                notLost.add(win);
                lost.put(win, 2); // to avoid duplicates
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLoss);

        return Arrays.asList(notLost, oneLoss);
    } 
}

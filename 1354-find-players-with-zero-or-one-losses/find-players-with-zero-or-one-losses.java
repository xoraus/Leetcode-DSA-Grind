import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int[] match : matches) {
            map1.put(match[0], map1.getOrDefault(match[0], 0) + 1);
            map2.put(match[1], map2.getOrDefault(match[1], 0) + 1);
        }

        for (int key : map2.keySet()) {
            if (map2.get(key) == 1) {
                oneLost.add(key);
            }
        }

        for (int key : map1.keySet()) {
            if (map2.get(key) == null) {
                notLost.add(key);
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLost);

        return Arrays.asList(notLost, oneLost);
    }
}

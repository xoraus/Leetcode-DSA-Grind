class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();

        for (int[] match : matches) {
            lossCount.put(match[1], lossCount.getOrDefault(match[1], 0) + 1);
        }

        Set<Integer> allPlayers = new HashSet<>();
        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int[] match : matches) {
            allPlayers.add(match[0]);
            allPlayers.add(match[1]);
        }

        for (int player : allPlayers) {
            int losses = lossCount.getOrDefault(player, 0);
            if (losses == 0) {
                noLosses.add(player);
            } else if (losses == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(noLosses);
        Collections.sort(oneLoss);

        return Arrays.asList(noLosses, oneLoss);
    }
}
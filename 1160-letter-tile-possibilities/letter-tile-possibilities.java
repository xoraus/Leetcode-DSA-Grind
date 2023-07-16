class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, visited, "", set);
        return set.size();
    }

    public void backtrack(String tiles, boolean[] visited, String currentSequence, HashSet<String> set) {
        if (currentSequence.length() > 0) {
            set.add(currentSequence);
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(tiles, visited, currentSequence + tiles.charAt(i), set);
                visited[i] = false;
            }
        }
    }
}

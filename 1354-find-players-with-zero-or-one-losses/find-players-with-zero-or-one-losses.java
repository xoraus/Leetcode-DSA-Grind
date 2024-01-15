class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res0 = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int[] match: matches){
            map1.put(match[0], map1.getOrDefault(match[0], 0) + 1);
            map2.put(match[1], map2.getOrDefault(match[1], 0) + 1);
        }

        for(int key: map2.keySet()){
            if(map2.get(key) == 1) res1.add(key);
        }

        for(int key: map1.keySet()){
            if(map2.get(key) == null) res0.add(key);
        }

        Collections.sort(res0);
        Collections.sort(res1);

        res.add(res0);
        res.add(res1);

        return res;
    }
}
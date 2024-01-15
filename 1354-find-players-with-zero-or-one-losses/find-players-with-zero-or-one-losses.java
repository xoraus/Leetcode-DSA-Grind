class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> match0 = new ArrayList<>();
        List<Integer> match1 = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res0 = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        
        for(int[] match: matches){
            match0.add(match[0]);
            match1.add(match[1]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val: match1){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == 1) res1.add(key);
        }

        HashSet<Integer> set0 = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for(int[] match: matches){
            set0.add(match[0]);
            set1.add(match[1]);
        }

        for(int val : set0){
            if(!set1.contains(val)) res0.add(val);
        }

        Collections.sort(res0);
        Collections.sort(res1);

        res.add(res0);
        res.add(res1);

        return res;
    }
}
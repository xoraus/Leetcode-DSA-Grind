class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(set.contains(freq)){
                return false;
            }
            set.add(freq);
        }

        return true;
    }
}
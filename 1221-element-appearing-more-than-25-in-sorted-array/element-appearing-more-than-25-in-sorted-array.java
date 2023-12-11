class Solution {
    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq > threshold) return key;
        }
        
        return -1;
    }
}
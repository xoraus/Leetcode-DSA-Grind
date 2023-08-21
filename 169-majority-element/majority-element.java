class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        HashMap<Integer, Integer> countMap = new HashMap<>();        

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(int key: countMap.keySet()){
            if(countMap.get(key) > threshold){
                return key;
            }
        }

        return -1;
    }
}
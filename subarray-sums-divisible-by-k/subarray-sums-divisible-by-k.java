class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int pref = 0, count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty subarray

        for(int val: nums){
            pref = ((pref + val) % k + k) % k;
            int freq = map.getOrDefault(pref, 0);
            count += freq;
            map.put(pref, freq + 1);
        }
        return count;
    }
}
class Solution {
    public int numIdenticalPairs(int[] guestList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int friend: guestList) {
            int friendCount = map.getOrDefault(friend, 0);
            count += friendCount;
            map.put(friend, friendCount + 1);
        }        
        return count;
    }
}
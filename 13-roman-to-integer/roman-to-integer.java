class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mymap = new HashMap<>();
        mymap.put('I', 1);
        mymap.put('V', 5);
        mymap.put('X', 10);
        mymap.put('L', 50);
        mymap.put('C', 100);
        mymap.put('D', 500);
        mymap.put('M', 1000);

        int value = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 < s.length() && mymap.get(s.charAt(i)) < mymap.get(s.charAt(i + 1))) {
                value -= mymap.get(s.charAt(i));
            } else {
                value += mymap.get(s.charAt(i));
            }
        }
        return value;
    }
}
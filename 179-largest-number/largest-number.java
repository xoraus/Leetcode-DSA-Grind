class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int val : nums) numsList.add(val);

        Collections.sort(numsList, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                String ab = num1 + "" + num2;
                String ba = num2 + "" + num1;
                return ba.compareTo(ab);
            }
        });

        StringBuilder res = new StringBuilder();
        for (int idx = 0; idx < numsList.size(); idx++) {
            res.append(numsList.get(idx));
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}
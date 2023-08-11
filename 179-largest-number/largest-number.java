class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>();
        
        for (int val : nums)
            numStrings.add(Integer.toString(val));
        
        Collections.sort(numStrings, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        
        StringBuilder largestNumber = new StringBuilder();
        
        for (String str : numStrings)
            largestNumber.append(str);
        
        return largestNumber.charAt(0) == '0' ? "0" :  largestNumber.toString();
    }
}
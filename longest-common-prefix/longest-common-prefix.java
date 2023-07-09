class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder(strs[0]);

        for(int idx = 1; idx < strs.length; idx++){
            String currString = strs[idx];
            int commonSize = commonPrefix.length();
            int currSize = currString.length();
            
            int p1 = 0, p2 = 0;
            StringBuilder prefix = new StringBuilder();
            while(p1 < commonSize && p2 < currSize && currString.charAt(p1) == commonPrefix.charAt(p2)){
                prefix.append(commonPrefix.charAt(p2));
                p1++; p2++;
            }
            commonPrefix = prefix;
        }
        return commonPrefix.toString();
    }
}
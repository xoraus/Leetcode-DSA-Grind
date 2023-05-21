class Solution {
    public List<String> letterCombinations(String input) {
        List<String> res = new ArrayList<>();
        if (input.length() == 0) return res;
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(input, 0, "", map, res);
        return res;
    }

    public void helper(String input, int idx, String output, String[] map, List<String> res) {
        if (idx == input.length()) {
            res.add(output);
            return;
        }

        int digit = input.charAt(idx) - '0';
        for (char letter : map[digit].toCharArray()) {
            helper(input, idx + 1, output + letter, map, res);
        }
    }
}
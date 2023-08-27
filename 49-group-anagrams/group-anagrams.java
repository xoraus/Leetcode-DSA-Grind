class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        
        for (String word : strs) {
            int[] charFrequency = new int[26]; // Assuming only lowercase English letters
            
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                charFrequency[ch - 'a']++;
            }
            
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charFrequency) {
                keyBuilder.append('#');
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();
            
            if (!groupedAnagrams.containsKey(key)) {
                groupedAnagrams.put(key, new ArrayList<>());
            }
            groupedAnagrams.get(key).add(word);
        }
        
        return new ArrayList<>(groupedAnagrams.values());
    }
}

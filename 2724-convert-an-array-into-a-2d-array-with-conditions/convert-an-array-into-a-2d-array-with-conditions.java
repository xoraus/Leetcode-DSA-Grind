class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] elementFrequency = new int[nums.length + 1];

        List<List<Integer>> resultMatrix = new ArrayList<>();
        for (int currentElement : nums) {
            
            if (elementFrequency[currentElement] == resultMatrix.size()) {
        
                resultMatrix.add(new ArrayList<>());
            }

        
            resultMatrix.get(elementFrequency[currentElement]).add(currentElement);
        
            elementFrequency[currentElement]++;
        }
        return resultMatrix;
    }
}
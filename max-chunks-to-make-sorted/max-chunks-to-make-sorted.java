class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, max = 0;
        
        for(int idx = 0; idx < arr.length; idx++){
            max = Math.max(max, arr[idx]);
            if(idx >= max){
                chunks++;
            }
        }

        return chunks;
    }
}
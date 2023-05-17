class Solution {
    public int largestAltitude(int[] gain) {
        int answer = 0, altitude = 0;

        for(int val: gain){
            altitude += val;
            answer = Math.max(answer, altitude);
        }
        
        return answer;
    }
}
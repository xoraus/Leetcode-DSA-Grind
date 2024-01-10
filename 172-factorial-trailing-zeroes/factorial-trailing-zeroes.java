class Solution {
    public int trailingZeroes(int num) {
        int count = 0;
        
        while(num > 0){
            num = num / 5;
            count += num;
        }
        return count;
    }
}
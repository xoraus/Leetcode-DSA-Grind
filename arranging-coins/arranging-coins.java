class Solution {
    public int arrangeCoins(int n) {
        long left = 1, right = n;
        int res = 0;

        while(left <= right){
            long mid = left + (right - left) / 2;
            long coinsUsed = mid * (mid + 1) / 2;

            if(coinsUsed > n){
                right = mid - 1;
            } else {
                left = mid + 1;
                res = (int)Math.max(res, mid);
            }
        }

        return res;
    }
}
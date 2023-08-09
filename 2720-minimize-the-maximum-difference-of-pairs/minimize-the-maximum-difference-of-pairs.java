class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);

        int low = 0;
        int high = nums[n - 1] - nums[0];

        int minMaxDifference = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, mid, p)){
                minMaxDifference = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minMaxDifference;
    }

    public boolean isPossible(int[] nums, int mid, int p){
        int i = 0, countPairs = 0;
        while(i < nums.length - 1){
            if(nums[i + 1] - nums[i] <= mid){
                countPairs++;
                i += 2; 
            } else{
                i++;
            }
        }

        return (countPairs >= p);
    }
}
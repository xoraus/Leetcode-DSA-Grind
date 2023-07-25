class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        int[] pmax = prefixMax(height);
        int[] smax = suffixMax(height);

        for(int i = 0; i < n; i++){
            int level = Math.min(pmax[i],smax[i]);
            int water = level - height[i];
            waterTrapped += water;
        }
        return waterTrapped;
    }

    public int[] prefixMax(int[] arr){
        int n = arr.length;
        int[] pmax = new int[arr.length];
        pmax[0] = arr[0]; 

        for(int i = 1; i < n; i++){
            pmax[i] = Math.max(arr[i],pmax[i-1]);
        }
        return pmax;
    }

    public int[] suffixMax(int[] arr){
        int n = arr.length;
        int[] smax = new int[arr.length];
        smax[n-1] = arr[n-1];
    
        for(int i = n-2; i >= 0; i--){
            smax[i] = Math.max(arr[i],smax[i+1]);
        }
        return smax;
    }
}


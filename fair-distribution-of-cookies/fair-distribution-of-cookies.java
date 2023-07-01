class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] counts = new int[k];
        return dfs(cookies, counts, 0);
    }

    public int dfs(int[] cookies, int[] counts, int idx) {
        if(idx == cookies.length) {
            int max = counts[0];
            for(int count : counts) {
                max = Math.max(max, count);
            }
            return max;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<counts.length; i++) {
            counts[i] += cookies[idx];
            res = Math.min(res, dfs(cookies, counts, idx+1));
            counts[i] -= cookies[idx];
        }
        return res;
    }
}
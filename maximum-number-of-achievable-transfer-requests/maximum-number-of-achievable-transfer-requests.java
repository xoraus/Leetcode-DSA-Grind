class Solution {
    int ans = 0;
    int[][] requests;
    public void backtracking(int[] transfers, int idx, int count){
        if(idx == requests.length){
            for(int req :transfers){
                if(req != 0) return;
            }
            ans = Math.max(ans, count);
            return;
        }

        transfers[requests[idx][0]]--;
        transfers[requests[idx][1]]++;
        backtracking(transfers, idx + 1, count + 1);
        transfers[requests[idx][0]]++;
        transfers[requests[idx][1]]--;
        backtracking(transfers, idx + 1, count);

    }
    public int maximumRequests(int n, int[][] requests) {
        this.requests = requests;
        int[] transfers = new int[n];
        backtracking(transfers, 0, 0);
        return ans;
    }
}
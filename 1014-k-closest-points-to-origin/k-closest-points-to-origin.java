class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int res[][] = new int[k][2];
        
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
            int x = (a[0] * a[0]) + (a[1] * a[1]);
            int y = (b[0] * b[0]) + (b[1] * b[1]);
            return x - y;
            }   
        });

        for(int idx = 0; idx < k; idx++) {
            res[idx][0] = points[idx][0];
            res[idx][1] = points[idx][1];
        }

        return res;
    }
}
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        ArrayList<Integer> listPos = new ArrayList<>();
        ArrayList<Integer> listNeg = new ArrayList<>();

        for(int num: nums){
            if(num > 0) listPos.add(num);
            else listNeg.add(num);
        }

        int idx = 0, resIdx = 0;
        while(idx < res.length / 2){
            res[resIdx++] = listPos.get(idx);
            res[resIdx++] = listNeg.get(idx);
            idx++;
        }
        return res;   
    }
}
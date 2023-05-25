class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stk = new ArrayList<>();

        for(int idx = 0; idx < asteroids.length; idx++){
            int right = asteroids[idx];

            if(right > 0) stk.add(right);
            else if(stk.size() == 0 || stk.get(stk.size() - 1) < 0){
                stk.add(right);
            }
            else if(stk.get(stk.size() - 1) < -right){
                stk.remove(stk.size() -1);
                idx--; // to consider bigger asteroid again.
            }
            else if(stk.get(stk.size() -1) == -right){
                stk.remove(stk.size() -1 );
            }
        }

        int[] res = new int[stk.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stk.get(i);
        }
        return res;
    }
}
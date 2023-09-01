class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;

        while(left <= right){
            int w = people[left] + people[right];
            if(w > limit){
                res += 1;
                right --;
            } else if ( w <= limit){
                res += 1;
                left++; right--;
            }
        }
        return res;
    }
}
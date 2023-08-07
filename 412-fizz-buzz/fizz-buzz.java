class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int currNum = 1;
        
        while(currNum <= n){
            if(currNum % 3 == 0 && currNum % 5 == 0){
                res.add("FizzBuzz");
            } else if(currNum % 3 == 0){
                res.add("Fizz");
            } else if(currNum % 5 == 0){
                res.add("Buzz");
            } else {
                res.add(String.valueOf(currNum));
            }
            currNum++;
        }
        return res;
    }
}
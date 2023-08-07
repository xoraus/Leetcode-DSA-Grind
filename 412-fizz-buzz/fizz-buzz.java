class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        while(n > 0){
            if(n % 3 == 0 && n % 5 == 0){
                res.add("FizzBuzz");
            } else if(n % 3 == 0){
                res.add("Fizz");
            } else if(n % 5 == 0){
                res.add("Buzz");
            } else {
                res.add(String.valueOf(n));
            }
            n--;
        }
        Collections.reverse(res);
        return res;
    }
}
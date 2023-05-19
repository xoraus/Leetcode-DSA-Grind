class Solution {
    public double power(double x, long n){
        if(n == 0) return 1.0;

        double smallWork = power(x, n / 2);
        double bigWork = smallWork * smallWork;

        if(n % 2 == 1) bigWork = bigWork * x;

        return bigWork;
    }
    public double myPow(double x, int n) {
        if(n < 0) return power(1 / x, -1l * n);
        return power(x,n);
    }
}
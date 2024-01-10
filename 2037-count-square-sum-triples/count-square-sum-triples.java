class Solution {
    public int countTriples(int n) {
        int tripleCount = 0;

        for (int a = 1; a <= n - 2; a++) {
            for (int b = a + 1; b <= n - 1; b++) {
                int cSquared = a * a + b * b;
                int c = (int) Math.sqrt(cSquared);
                if (c * c == cSquared && c >= b + 1 && c <= n) {
                    tripleCount += 2;  
                }
            }
        }

        return tripleCount;
    }
}
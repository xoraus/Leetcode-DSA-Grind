class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] res = new int[len1 + len2];
        int i = len2 - 1;
        int pf = 0; // power factor

        while (i >= 0) {
            int val = num2.charAt(i) - '0';
            i--;

            int j = len1 - 1;
            int k = res.length - 1 - pf;
            int carry = 0;

            while (j >= 0 || carry != 0) {
                int jval = (j >= 0) ? num1.charAt(j) - '0' : 0;
                j--;

                int prod = val * jval + carry + res[k];
                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }

        // Management of leading zero using the general method
        StringBuilder str = new StringBuilder();
        boolean flag = false;

        for (int val : res) {
            if (val != 0 && !flag) {
                flag = true; // leading zero encountered
            }

            if (flag) {
                str.append(val);
            }
        }

        return str.toString();
    }
}
class Solution {
    String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1 + length2];
        int index2 = length2 - 1;
        int positionFactor = 0;
        
        while (index2 >= 0) {
            int index1 = length1 - 1;
            int carry = 0;
            int product = 1;
            int currentIndex = result.length - 1 - positionFactor;
            
            while (index1 >= 0) {
                product = ((num2.charAt(index2) - '0') * (num1.charAt(index1) - '0') + carry + result[currentIndex]) % 10;
                carry = ((num2.charAt(index2) - '0') * (num1.charAt(index1) - '0') + carry + result[currentIndex]) / 10;
                result[currentIndex--] = product;
                index1--;
            }
            
            result[currentIndex--] = carry;
            positionFactor++;
            index2--;
        }
        
        StringBuilder answer = new StringBuilder();
        int startIndex = 0;
        
        while (startIndex < result.length && result[startIndex] == 0) {
            startIndex++;
        }
        
        for (; startIndex < result.length; startIndex++) {
            answer.append(result[startIndex]);
        }
        
        return answer.toString();
    }

}
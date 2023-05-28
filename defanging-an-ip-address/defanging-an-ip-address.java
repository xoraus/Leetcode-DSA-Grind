class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();

        for(int idx = 0; idx < address.length(); idx++){
            char ch = address.charAt(idx);
            if(ch == '.'){
                res.append("[.]");
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
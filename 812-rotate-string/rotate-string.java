class Solution {
    public boolean rotateString(String original, String target) {
        if (original == null || target == null) {
            // Throw an exception on both original and target being null?
            return false;
        }
        if (original.length() != target.length()) {
            return false;
        }
        if (original.length() == 0) {
            return true;
        }
        for (int rotation = 0; rotation < original.length(); rotation++) {
            if (isRotatedString(original, target, rotation)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isRotatedString(String original, String target, int rotation) {
        for (int i = 0; i < original.length(); i++) {
            int rotatedIndex = (i + rotation) % target.length();
            if (original.charAt(i) != target.charAt(rotatedIndex)) {
                return false;
            }
        }
        return true;
    }
}

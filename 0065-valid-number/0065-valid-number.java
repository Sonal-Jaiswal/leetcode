class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // remove leading/trailing spaces
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenE) digitAfterE = true;
            } else if (c == '+' || c == '-') {
                // Sign is only valid at the start or right after 'e' or 'E'
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // Only one dot allowed, and no dot after 'e'
                if (seenDot || seenE) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // Only one e allowed, and must come after a digit
                if (seenE || !seenDigit) return false;
                seenE = true;
                digitAfterE = false; // must have digits after e
            } else {
                return false;
            }
        }

        return seenDigit && digitAfterE;
    }
}

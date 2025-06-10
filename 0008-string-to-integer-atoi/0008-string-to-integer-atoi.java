class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        int n = s.length();

        // Step 1: Remove leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for optional sign
        if (index < n) {
            char currentChar = s.charAt(index);
            if (currentChar == '+' || currentChar == '-') {
                sign = (currentChar == '-') ? -1 : 1;
                index++;
            }
        }

        // Step 3: Convert digits to number
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Step 4: Check for overflow before adding the digit
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}

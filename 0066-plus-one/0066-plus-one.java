public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment it and return the result
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // Set the current digit to 0 and move to the next digit
            digits[i] = 0;
        }

        // If we are here, it means all digits were 9 and we need an extra digit at the start
        int[] result = new int[n + 1];
        result[0] = 1; // The most significant digit will be 1
        return result;
    }
}

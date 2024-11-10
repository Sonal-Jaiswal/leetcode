public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last element
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment and return immediately
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, set it to 0 and continue to the next significant digit
            digits[i] = 0;
        }

        // If we are here, all digits were 9, so we need an extra digit at the beginning
        // Create a new array with one extra slot, setting the first digit to 1
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }
}

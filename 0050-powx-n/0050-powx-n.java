class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponent
        long N = n; // Use long to avoid overflow when n == Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if ((N % 2) == 1) {  // If N is odd
                result *= x;
            }
            x *= x;     // Square the base
            N /= 2;     // Divide the exponent by 2
        }

        return result;
    }
}

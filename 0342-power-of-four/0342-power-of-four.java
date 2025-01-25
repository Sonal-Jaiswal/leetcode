class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false; // Must be positive
        while (n % 4 == 0) {
            n /= 4; // Divide by 4 as long as possible
        }
        return n == 1; // If n becomes 1, it is a power of 4
    }
}

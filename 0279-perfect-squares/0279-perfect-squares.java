class Solution {
    public int numSquares(int n) {
        // Array to store the minimum number of squares required for each value up to n
        int[] dp = new int[n + 1];

        // Initialize the dp array with max values
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: 0 requires 0 squares
        dp[0] = 0;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}

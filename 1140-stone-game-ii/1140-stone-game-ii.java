class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum of piles[i ... n-1]
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][m] = maximum stones the current player can get
        // starting from index i with current M = m
        int[][] dp = new int[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int m, int[] piles, int[] suffix, int[][] dp) {
        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        // Can take all remaining piles
        if (2 * m >= n - i) {
            return dp[i][m] = suffix[i];
        }

        int best = 0;

        // Take X piles, where 1 <= X <= 2M
        for (int x = 1; x <= 2 * m; x++) {
            // Current player gets piles[i ... i+x-1]
            int current = suffix[i] - suffix[i + x];

            // Opponent gets the best possible result from remaining piles
            int opponent = solve(i + x, Math.max(m, x), piles, suffix, dp);

            // Total available = suffix[i]
            // So current player's final stones:
            // suffix[i] - opponent's best
            best = Math.max(best, suffix[i] - opponent);
        }

        return dp[i][m] = best;
    }
}
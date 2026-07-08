class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Prefix count of non-zero digits
        int[] count = new int[n + 1];
        int nonZero = 0;

        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];
            if (s.charAt(i) != '0') {
                count[i + 1]++;
                nonZero++;
            }
        }

        // Store non-zero digits
        int[] digits = new int[nonZero];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                digits[idx++] = s.charAt(i) - '0';
            }
        }

        // Powers of 10 modulo MOD
        long[] pow10 = new long[nonZero + 1];
        pow10[0] = 1;
        for (int i = 1; i <= nonZero; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix values and prefix digit sums
        long[] prefixValue = new long[nonZero + 1];
        long[] prefixSum = new long[nonZero + 1];

        for (int i = 0; i < nonZero; i++) {
            prefixValue[i + 1] = (prefixValue[i] * 10 + digits[i]) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digits[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = count[l];
            int right = count[r + 1];

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;

            long x = (prefixValue[right] - (prefixValue[left] * pow10[len]) % MOD + MOD) % MOD;
            long sum = prefixSum[right] - prefixSum[left];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}
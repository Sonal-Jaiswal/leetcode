class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] freq = new int[mx + 1];
        for (int x : nums) freq[x]++;

        int[] cnt = new int[mx + 1];

        // numbers divisible by i
        for (int i = 1; i <= mx; i++) {
            for (int j = i; j <= mx; j += i) {
                cnt[i] += freq[j];
            }
        }

        long[] exact = new long[mx + 1];

        // inclusion exclusion
        for (int i = mx; i >= 1; i--) {
            long pairs = 1L * cnt[i] * (cnt[i] - 1) / 2;

            for (int j = i + i; j <= mx; j += i) {
                pairs -= exact[j];
            }

            exact[i] = pairs;
        }

        long[] prefix = new long[mx + 1];
        for (int i = 1; i <= mx; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // 1-based position

            int l = 1, r = mx;
            while (l < r) {
                int mid = (l + r) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}
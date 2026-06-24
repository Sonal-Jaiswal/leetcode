class Solution {
    static final long MOD = 1_000_000_007L;

    private long[][] mul(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long x = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + x * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[] mulMatVec(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }

    private long[] powerApply(long[][] base, long exp, long[] vec) {
        while (exp > 0) {
            if ((exp & 1) == 1) {
                vec = mulMatVec(base, vec);
            }

            base = mul(base, base);
            exp >>= 1;
        }

        return vec;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        int size = 2 * m;

        long[] vec = new long[size];

        // length = 2
        for (int i = 0; i < m; i++) {
            vec[i] = i;              // up[i]
            vec[m + i] = m - 1 - i; // down[i]
        }

        if (n == 2) {
            long ans = 0;
            for (long x : vec) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] T = new long[size][size];

        // up[i] <- down[j], j < i
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[i][m + j] = 1;
            }
        }

        // down[i] <- up[j], j > i
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                T[m + i][j] = 1;
            }
        }

        vec = powerApply(T, n - 2L, vec);

        long ans = 0;

        for (long x : vec) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}
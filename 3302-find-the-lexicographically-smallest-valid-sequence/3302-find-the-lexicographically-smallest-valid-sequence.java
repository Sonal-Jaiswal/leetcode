class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // exact[i] = how many characters from the end of word2
        // can be matched exactly in word1[i...].
        int[] exact = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            exact[i] = m - 1 - j;
        }

        int[] ans = new int[m];

        int prev = -1;
        boolean mismatchUsed = false;

        for (j = 0; j < m; j++) {
            int remaining = m - j - 1;
            boolean found = false;

            for (int i = prev + 1; i < n; i++) {
                boolean mismatch =
                    word1.charAt(i) != word2.charAt(j);

                if (mismatch && mismatchUsed) {
                    continue;
                }

                /*
                 * If we mismatch here, everything after i
                 * must match exactly.
                 */
                if (mismatch) {
                    if (remaining > exact[i + 1]) {
                        continue;
                    }
                } else {
                    /*
                     * We haven't used the mismatch yet.
                     *
                     * If there are 'remaining' characters,
                     * we can always allow one of them to be
                     * the mismatch, so we only need enough
                     * characters remaining.
                     */
                    if (n - (i + 1) < remaining) {
                        continue;
                    }
                }

                ans[j] = i;
                prev = i;
                mismatchUsed |= mismatch;
                found = true;
                break;
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}
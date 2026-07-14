class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += (num & 1);
            num >>= 1;
        }
        return cnt;
    }
}
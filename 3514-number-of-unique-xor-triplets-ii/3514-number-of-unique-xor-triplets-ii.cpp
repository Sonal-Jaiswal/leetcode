class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        unordered_set<int> st(nums.begin(), nums.end());
        vector<int> vals(st.begin(), st.end());

        const int MAXX = 2048;

        vector<bool> pairXor(MAXX, false);
        for (int a : vals) {
            for (int b : vals) {
                pairXor[a ^ b] = true;
            }
        }

        vector<bool> ans(MAXX, false);
        for (int x = 0; x < MAXX; x++) {
            if (!pairXor[x]) continue;
            for (int v : vals) {
                ans[x ^ v] = true;
            }
        }

        int cnt = 0;
        for (bool x : ans) cnt += x;
        return cnt;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
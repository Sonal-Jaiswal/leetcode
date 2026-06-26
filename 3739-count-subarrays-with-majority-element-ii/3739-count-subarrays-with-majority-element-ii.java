import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Prefix sums
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] temp = prefix.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx);

        long ans = 0;

        for (int p : prefix) {
            int rank = map.get(p);

            // Count previous prefix sums < current
            ans += bit.query(rank - 1);

            // Insert current prefix
            bit.update(rank, 1);
        }

        return ans;
    }

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}
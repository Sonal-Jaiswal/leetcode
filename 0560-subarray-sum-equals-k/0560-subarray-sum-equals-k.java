class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Compute the prefix sum array
        int[] prefixSum = new int[n + 1]; // Extra space for 0 at index 0
        prefixSum[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Step 2: Find subarrays with sum equal to k
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Sum of subarray nums[i...j] = prefixSum[j+1] - prefixSum[i]
                if (prefixSum[j + 1] - prefixSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

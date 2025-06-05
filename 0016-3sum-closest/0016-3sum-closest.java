

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array first
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with first three

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If this is closer to target than the previous closest, update it
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;  // Need a bigger sum
                } else if (currentSum > target) {
                    right--; // Need a smaller sum
                } else {
                    return currentSum;  // Exact match
                }
            }
        }

        return closestSum;
    }
}

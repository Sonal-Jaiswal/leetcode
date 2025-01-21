class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Step 1: Cycle Sort to place elements at their correct positions
        for (int i = 0; i < n; i++) {
            // Continue swapping until nums[i] is in the correct position or out of bounds
            while (nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]) {
                // Swap nums[i] with nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }

        // Step 2: Find the first index where the number does not match the index
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i; // Missing number is `i`
            }
        }

        // Step 3: If all elements are in their correct positions, the missing number is `n`
        return n;
    }
}

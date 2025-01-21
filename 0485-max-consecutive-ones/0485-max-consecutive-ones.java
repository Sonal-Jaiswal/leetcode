class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;

        for (int num : nums) { // Enhanced for loop for better readability
            if (num == 1) {
                maxCount = Math.max(maxCount, ++count); // Update maxCount inline
            } else {
                count = 0; // Reset count on encountering 0
            }
        }

        return maxCount;
    }
}

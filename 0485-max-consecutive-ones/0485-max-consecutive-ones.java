class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0; 
        int maxCount = 0; 

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++; 
                maxCount = Math.max(maxCount, count); // Update maxCount if necessary
            } else {
                count = 0; // Reset count when encountering a '0'
            }
        }

        return maxCount; // Return the maximum count of consecutive ones
    }
}

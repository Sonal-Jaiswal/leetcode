class Solution {
    public void sortColors(int[] nums) {
        // Temporary array to store the counts
        int[] temp = new int[nums.length];
        int index = 0;

        // Count all 0s and add them to the temp array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp[index++] = 0;
            }
        }

        // Count all 1s and add them to the temp array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp[index++] = 1;
            }
        }

        // Count all 2s and add them to the temp array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                temp[index++] = 2;
            }
        }

        // Copy the sorted elements from temp back to nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}

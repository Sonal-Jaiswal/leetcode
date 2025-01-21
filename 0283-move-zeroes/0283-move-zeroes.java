class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // Pointer to track the position of the next non-zero element
        int index = 0;

        // Iterate through the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Fill the rest of the array with zeros
        while (index < n) {
            nums[index++] = 0;
        }
    }
}

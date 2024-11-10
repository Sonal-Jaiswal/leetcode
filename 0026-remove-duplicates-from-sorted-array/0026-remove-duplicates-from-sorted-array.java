class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Pointer i will point to the last unique element's position
        int i = 0;

        // Iterate through the array starting from index 1
        for (int j = 1; j < nums.length; j++) {
            // If nums[j] is different from nums[i], it's a new unique element
            if (nums[j] != nums[i]) {
                i++;  // Move the pointer to the next position
                nums[i] = nums[j];  // Place the unique element in its correct position
            }
        }

        // The number of unique elements is i + 1
        return i + 1;
    }
}

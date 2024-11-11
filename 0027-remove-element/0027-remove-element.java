class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // Pointer to track the next position for a non-val element
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];  // Move element to the "new" array position
                k++;  // Increment the count of valid elements
            }
        }
        
        return k;  // Return the number of elements that are not equal to val
    }
}

class Solution {
    public boolean check(int[] nums) {
        int count = 0; // To count the number of decreases in the array
        
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next element (circularly)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // If there is more than one decrease, it's not sorted and rotated
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}

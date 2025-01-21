// one more approach
// reverse the entire array then reverse the first k element and then the next k
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than the array length

        // Step 1: Create a temporary array to store the rotated result
        int[] temp = new int[n];

        // Step 2: Copy the last k elements to the beginning of the temp array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Step 3: Copy the first n-k elements to the remaining positions
        for (int i = 0; i < n - k; i++) {
            temp[k + i] = nums[i];
        }

        // Step 4: Copy the temp array back to the original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}

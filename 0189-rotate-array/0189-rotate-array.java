// one more approach
// reverse the entire array then reverse the first k element and then the next k
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n; // Handle cases where k is greater than the array length

//         // Step 1: Create a temporary array to store the rotated result
//         int[] temp = new int[n];

//         // Step 2: Copy the last k elements to the beginning of the temp array
//         for (int i = 0; i < k; i++) {
//             temp[i] = nums[n - k + i];
//         }

//         // Step 3: Copy the first n-k elements to the remaining positions
//         for (int i = 0; i < n - k; i++) {
//             temp[k + i] = nums[i];
//         }

//         // Step 4: Copy the temp array back to the original array
//         for (int i = 0; i < n; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is larger than array length

        // Reverse the entire array
        reverse(nums, 0, n - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse elements of the array between two indices
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Step 1: Separate positive and negative numbers
        int[] positive = new int[n];
        int[] negative = new int[n];
        int posIndex = 0, negIndex = 0;

        for (int num : nums) {
            if (num > 0) {
                positive[posIndex++] = num;
            } else {
                negative[negIndex++] = num;
            }
        }

        // Step 2: Merge alternately
        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < posIndex && j < negIndex) {
            result[k++] = positive[i++];
            result[k++] = negative[j++];
        }

        while (i < posIndex) {
            result[k++] = positive[i++];
        }

        while (j < negIndex) {
            result[k++] = negative[j++];
        }

        return result;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = sol.rearrangeArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

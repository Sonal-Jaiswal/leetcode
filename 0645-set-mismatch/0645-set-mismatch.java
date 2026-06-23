import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int duplicate = -1;
        int missing = -1;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                duplicate = nums[i];
            } else if (nums[i + 1] - nums[i] > 1) {
                missing = nums[i] + 1;
            }
        }

        // Edge cases
        if (nums[0] != 1) {
            missing = 1;
        }
        if (nums[n - 1] != n) {
            missing = n;
        }

        return new int[]{duplicate, missing};
    }
}
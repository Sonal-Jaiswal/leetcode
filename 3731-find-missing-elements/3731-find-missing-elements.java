class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i - 1] + 1; j < nums[i]; j++) {
                ans.add(j);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
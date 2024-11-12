public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }

        return false; // No duplicates found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums)); // Output: true
    }
}
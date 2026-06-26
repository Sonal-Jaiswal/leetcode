import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    continue;
                }
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;
        for (int num : set) {
            ans[index++] = num;
        }

        return ans;
    }
}



// optimised sol
// Time: O(n + m)
// Space: O(n) (or O(n + k), where k is the number of unique intersection elements)

// Set<Integer> set1 = new HashSet<>();
//         Set<Integer> result = new HashSet<>();

//         // Store all elements of nums1
//         for (int num : nums1) {
//             set1.add(num);
//         }

//         // Check elements of nums2
//         for (int num : nums2) {
//             if (set1.contains(num)) {
//                 result.add(num);
//             }
//         }

//         // Convert Set to int[]
//         int[] ans = new int[result.size()];
//         int index = 0;
//         for (int num : result) {
//             ans[index++] = num;
//         }

//         return ans;
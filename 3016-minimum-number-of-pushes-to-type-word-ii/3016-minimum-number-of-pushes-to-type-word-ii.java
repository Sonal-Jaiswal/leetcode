import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort ascending
        Arrays.sort(freq);

        int pushes = 0;
        int position = 0;

        // Traverse from highest frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            int cost = (position / 8) + 1;

            pushes += freq[i] * cost;

            position++;
        }

        return pushes;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
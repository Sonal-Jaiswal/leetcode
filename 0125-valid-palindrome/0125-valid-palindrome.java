class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Convert to lowercase and remove non-alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Use two pointers to check palindrome
        int left = 0;
        int right = sb.length() - 1;
        
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base for the first valid substring
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i); // push the index of '('
            } else {
                stack.pop(); // pop the last unmatched '('
                if (stack.isEmpty()) {
                    stack.push(i); // update the base for the next valid substring
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek()); // calculate length
                }
            }
        }

        return maxLen;
    }
}

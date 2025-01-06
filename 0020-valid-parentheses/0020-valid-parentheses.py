class Solution:
    def isValid(self, s: str) -> bool:
        # Dictionary to map closing brackets to their corresponding opening brackets
        bracket_map = {')': '(', '}': '{', ']': '['}
        stack = []

        for char in s:
            if char in bracket_map.values():  # If it's an opening bracket
                stack.append(char)
            elif char in bracket_map:  # If it's a closing bracket
                if not stack or stack[-1] != bracket_map[char]:
                    return False  # Stack is empty or mismatched brackets
                stack.pop()  # Remove the matched opening bracket
            else:
                return False  # Invalid character (though problem guarantees valid input)

        return not stack  # Stack should be empty if all brackets are matched

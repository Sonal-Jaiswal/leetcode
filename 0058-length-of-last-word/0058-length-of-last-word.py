class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        # Split the string into words
        words = s.split()
        # Return the length of the last word
        return len(words[-1])

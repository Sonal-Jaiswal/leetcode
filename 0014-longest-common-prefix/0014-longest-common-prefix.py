class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""
        
        # Sort the array of strings
        strs.sort()
        
        # Compare the first and last strings
        first = strs[0]
        last = strs[-1]
        i = 0
        
        # Find the common prefix between the first and last strings
        while i < len(first) and i < len(last) and first[i] == last[i]:
            i += 1
        
        return first[:i]

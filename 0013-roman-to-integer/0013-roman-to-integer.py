class Solution:
    def romanToInt(self, s: str) -> int:
        # Mapping of Roman numerals to their integer values
        roman_to_int = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        total = 0
        n = len(s)
        
        for i in range(n):
            # Check if this is a subtraction case
            if i < n - 1 and roman_to_int[s[i]] < roman_to_int[s[i + 1]]:
                total -= roman_to_int[s[i]]
            else:
                total += roman_to_int[s[i]]
        
        return total

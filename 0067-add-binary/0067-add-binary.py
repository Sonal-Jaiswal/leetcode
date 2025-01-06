class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # Initialize variables
        result = []
        carry = 0
        i, j = len(a) - 1, len(b) - 1
        
        # Traverse both strings from right to left
        while i >= 0 or j >= 0 or carry:
            # Get the current bit from a and b, or 0 if out of bounds
            bit_a = int(a[i]) if i >= 0 else 0
            bit_b = int(b[j]) if j >= 0 else 0
            
            # Compute the sum of bits and carry
            total = bit_a + bit_b + carry
            carry = total // 2  # Update carry (1 if sum >= 2, else 0)
            result.append(str(total % 2))  # Append the current bit (0 or 1)
            
            # Move to the next bits
            i -= 1
            j -= 1
        
        # Reverse the result and join to form the binary string
        return ''.join(reversed(result))

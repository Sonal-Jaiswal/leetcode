class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:  # For 0 and 1, the square root is the number itself
            return x

        # Binary search bounds
        left, right = 2, x // 2
        
        while left <= right:
            mid = (left + right) // 2
            square = mid * mid
            
            if square == x:  # Perfect square
                return mid
            elif square < x:  # Move to the right half
                left = mid + 1
            else:  # Move to the left half
                right = mid - 1
        
        # When loop ends, `right` will be the integer square root
        return right

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1; // Pointer for num1
        int j = num2.length() - 1; // Pointer for num2
        int carry = 0; // Initialize carry
        
        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0; // Get digit from num1 or 0
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0; // Get digit from num2 or 0
            int sum = digit1 + digit2 + carry; // Calculate sum
            carry = sum / 10; // Calculate new carry
            result.append(sum % 10); // Append last digit of sum to result
            i--;
            j--;
        }
        
        return result.reverse().toString(); // Reverse result to get the correct order
    }
}

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0"; // Special case for zero
        
        // Define the hexadecimal digits
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder hexString = new StringBuilder();
        
        // Process the number (up to 8 digits for a 32-bit number)
        while (num != 0 && hexString.length() < 8) {
            int last4Bits = num & 0xF; // Extract the last 4 bits
            hexString.append(hexChars[last4Bits]); // Map to hex character
            num >>>= 4; // Unsigned right shift by 4 bits
        }
        
        return hexString.reverse().toString(); // Reverse to get the correct order
    }
}

class Solution {
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area); // Start with W as the square root of the area
        while (area % W != 0) { // Find the largest W that divides the area
            W--;
        }
        int L = area / W; // Calculate L
        return new int[] {L, W}; // Return dimensions
    }
}

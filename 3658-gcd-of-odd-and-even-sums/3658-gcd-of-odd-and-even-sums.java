class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = n * n;
        int even = n * (n + 1);

        return GCD(odd, even);
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
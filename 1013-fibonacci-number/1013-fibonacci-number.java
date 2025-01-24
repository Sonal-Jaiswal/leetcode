class Solution {
    public int fib(int n) {
        if (n == 0) return 0; // Base case: fib(0) = 0
        if (n == 1) return 1; // Base case: fib(1) = 1
        
        int a = 0; // fib(0)
        int b = 1; // fib(1)
        for (int i = 2; i <= n; i++) {
            int temp = a + b; // Calculate fib(i)
            a = b;            // Update fib(i-2)
            b = temp;         // Update fib(i-1)
        }
        return b; // fib(n)
    }
}

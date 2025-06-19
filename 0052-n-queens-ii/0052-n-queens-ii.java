class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];           // Columns used
        boolean[] diag = new boolean[2 * n];       // Main diagonals (row - col)
        boolean[] antiDiag = new boolean[2 * n];   // Anti-diagonals (row + col)
        backtrack(0, n, cols, diag, antiDiag);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d = row - col + n;     // Shift index to keep it positive
            int ad = row + col;

            if (cols[col] || diag[d] || antiDiag[ad])
                continue;

            cols[col] = diag[d] = antiDiag[ad] = true;
            backtrack(row + 1, n, cols, diag, antiDiag);
            cols[col] = diag[d] = antiDiag[ad] = false;
        }
    }
}

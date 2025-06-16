class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use HashSet to keep track of seen numbers in rows, columns, and boxes
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                if (currentVal != '.') {
                    // Check row
                    if (!seen.add(currentVal + " in row " + i)) {
                        return false;
                    }

                    // Check column
                    if (!seen.add(currentVal + " in column " + j)) {
                        return false;
                    }

                    // Check 3x3 box
                    if (!seen.add(currentVal + " in box " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

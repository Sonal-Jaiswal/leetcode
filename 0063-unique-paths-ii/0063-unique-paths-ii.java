class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] arr = new int[m][n];

        if (obstacleGrid[0][0] == 1)
            return 0;

        arr[0][0] = 1;

        // First column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                arr[i][0] = 0;
            else
                arr[i][0] = arr[i - 1][0];
        }

        // First row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1)
                arr[0][j] = 0;
            else
                arr[0][j] = arr[0][j - 1];
        }

        // Remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    arr[i][j] = 0;
                else
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[m - 1][n - 1];
    }
}
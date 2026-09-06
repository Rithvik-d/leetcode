class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Iterate through each row starting from the second row (index 1)
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int minAbove = matrix[r - 1][c];
                
                if (c > 0) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c - 1]);
                }
                if (c < n - 1) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c + 1]);
                }
                
                matrix[r][c] += minAbove;
            }
        }

        // Find the minimum sum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int val : matrix[n - 1]) {
            minSum = Math.min(minSum, val);
        }

        return minSum;
    }
}
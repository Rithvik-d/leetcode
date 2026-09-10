class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        int row = 0, col = 0;
        int dir = 1; // 1 = up-right direction, -1 = down-left direction
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            if (dir == 1) { // Moving Up-Right
                if (col == n - 1) {      // Reached right boundary: move down and reverse
                    row++;
                    dir = -1;
                } else if (row == 0) {   // Reached top boundary: move right and reverse
                    col++;
                    dir = -1;
                } else {                 // Standard up-right step
                    row--;
                    col++;
                }
            } else { // Moving Down-Left
                if (row == m - 1) {      // Reached bottom boundary: move right and reverse
                    col++;
                    dir = 1;
                } else if (col == 0) {   // Reached left boundary: move down and reverse
                    row++;
                    dir = 1;
                } else {                 // Standard down-left step
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
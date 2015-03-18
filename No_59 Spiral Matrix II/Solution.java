public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];
        
        int nRows = n;
        int nCols = n;
        int up = 0;
        int down = n;
        int left = -1;
        int right = n;

        int i = 0, j = 0;
        int count = 1;
        int[][] matrix = new int[n][n];
        matrix[i][j] = count;
        count++;
        while (nRows > 0 && nCols > 0) {
            if (nCols > 0) {
                j++;
                for (; j < right; j++) {
                    matrix[i][j] = count;
                    count++;
                }
                nRows--;
                right--;
                j--;
            }
            else
                break;
            
            if (nRows > 0) {
                i++;
                for (; i < down; i++) {
                    matrix[i][j] = count;
                    count++;
                }
                nCols--;
                down--;
                i--;
            }
            else
                break;
            
            if (nCols > 0) {
                j--;
                for (; j > left; j--) {
                    matrix[i][j] = count;
                    count++;
                }
                nRows--;
                left++;
                j++;
            }
            else
                break;
            
            if (nRows > 0) {
                i--;
                for (; i > up; i--) {
                    matrix[i][j] = count;
                    count++;
                }
                nCols--;
                up++;
                i++;
            }
            else
                break;
        }
        return matrix;
    }
}
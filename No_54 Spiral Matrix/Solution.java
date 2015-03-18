public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0)
            return spiral;
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int up = 0;
        int down = matrix.length;
        int left = -1;
        int right = matrix[0].length;

        int i = 0, j = 0;
        spiral.add(matrix[i][j]);
        while (nRows > 0 && nCols > 0) {
            if (nCols > 0) {
                j++;
                for (; j < right; j++)
                    spiral.add(matrix[i][j]);
                nRows--;
                right--;
                j--;
            }
            else
                break;
            
            if (nRows > 0) {
                i++;
                for (; i < down; i++)
                    spiral.add(matrix[i][j]);
                nCols--;
                down--;
                i--;
            }
            else
                break;
            
            if (nCols > 0) {
                j--;
                for (; j > left; j--)
                    spiral.add(matrix[i][j]);
                nRows--;
                left++;
                j++;
            }
            else
                break;
            
            if (nRows > 0) {
                i--;
                for (; i > up; i--)
                    spiral.add(matrix[i][j]);
                nCols--;
                up++;
                i++;
            }
            else
                break;
        }
        return spiral;
    }
}
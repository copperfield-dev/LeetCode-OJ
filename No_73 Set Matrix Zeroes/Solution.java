public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < rows.length; i++)
            rows[i] = false;
        for (int j = 0; j < columns.length; j++)
            columns[j] = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i])
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
        }

        for (int j = 0; j < columns.length; j++) {
            if (columns[j])
                for (int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
        }
    }
}
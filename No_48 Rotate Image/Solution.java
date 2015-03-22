public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0)
            return;

        /* 沿主对角线先翻转 */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        /* 反转矩阵的每一行 */
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length / 2; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[i][matrix.length - 1 - k];
                matrix[i][matrix.length - 1 - k] = tmp;
            }
        }
    }
}
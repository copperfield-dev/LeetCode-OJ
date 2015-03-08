public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet(12, 0.75f);
        HashSet<Character> columnSet = new HashSet(12, 0.75f);
        HashSet<Character> cubeSet = new HashSet(12, 0.75f);

        /* i和j只是用来计数的 */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                /* 判断行的正确性 */
                if (board[i][j] != '.' && !rowSet.add(board[i][j]))
                    return false;

                /* 判断列的正确性 */
                if (board[j][i] != '.' && !columnSet.add(board[j][i]))
                    return false;

                /* 判断每一个cube的正确性 */
                int rowIndex = 3 * (i / 3);
                int columnIndex = 3 * (i % 3);
                if(board[rowIndex + j / 3][columnIndex + j % 3] != '.' 
                    && !cubeSet.add(board[rowIndex + j / 3][columnIndex + j % 3]))
                    return false;
            }
            rowSet.clear();
            columnSet.clear();
            cubeSet.clear();
        }
        return true;
    }
}
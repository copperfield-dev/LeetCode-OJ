public class Solution {
    private int move[][] = {{-1, 0, 1, 0}, 
                            {0, -1, 0, 1}}; 

    private boolean[][] visited; 
    
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        
        visited = new boolean[board.length][board[0].length]; 
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0))
                    if (backtrack(0, word, board, row, column))            //找到一次即可
                        return true;    
            }
        }
        return false;
    }

    public boolean backtrack(int index, String word,
        char[][] board, int row, int column) {
            if (index == word.length()) 
                return true;
                
        if (row < 0 || row >= board.length || 
            column < 0 || column >= board[0].length) 
            return false;
        if (visited[row][column])
            return false;
        if (word.charAt(index) != board[row][column]) 
            return false;

        visited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            int newRow =  row + move[0][i];
            int newColumn = column + move[1][i];
            if (backtrack(index + 1, word, board, newRow, newColumn))
                return true;
        }
        visited[row][column] = false;
        return false;
    }
}
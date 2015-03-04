public class Solution {
    public int totalNQueens(int n) {
        int[] chessboard = new int[n];
        /* 棋盘初始化 */
        for (int k = 0; k < n; k++)
            chessboard[k] = -10000;  
        int countAnswer = 0;
        int i = 0, j = 0;

        while (i < n) {
            while (j < n) {                     //对i行的每一列进行探测, 看是否可以放置皇后
                if (valid(i, j, chessboard)) {  //该位置可以放置皇后 
                    chessboard[i] = j;          //第i行放置皇后
                    j = 0;       //第i行放置皇后以后, 需要继续探测下一行的皇后位置, 所以此处将j清零, 从下一行的第0列开始逐列探测
                    break;
                }
                else
                    ++j;                        //继续探测下一列    
            }
            if (chessboard[i] == -10000) {      //第i行没有找到可以放置皇后的位置    
                if (i == 0)                     //回溯到第一行，仍然无法找到可以放置皇后的位置, 则说明已经找到所有的解, 程序终止
                    break;
                else {                          //没有找到可以放置皇后的列, 此时就应该回溯
                    --i;
                    j = chessboard[i] + 1;      //把上一行皇后的位置往后移一列
                    chessboard[i] = -10000;     //把上一行皇后的位置清除，重新探测    
                    continue;
                }
            }

            if (i == n - 1) {                   //最后一行找到了一个皇后位置, 说明找到一个结果
                countAnswer++;
                /* 此时应该清除该行的皇后, 从当前放置皇后列数的下一列继续探测 */
                j = chessboard[i] + 1;          //从最后一行放置皇后列数的下一列继续探测
                chessboard[i] = -10000;         //清除最后一行的皇后位置
                continue;
            }
            ++i;                                //继续探测下一行的皇后位置
        }
        return countAnswer;
    }

    public boolean valid(int row, int col, int[] chessboard) {
        for (int i = 0; i < chessboard.length; ++i) 
            if (chessboard[i] == col 
                || Math.abs(i - row) == Math.abs(chessboard[i] - col))
                return false;
        return true;
    }
}
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false; 
            
        int lo = 0;
        int hi = matrix.length - 1;

        int midCol = 0;
        while (lo <= hi) {
            midCol = lo + (hi - lo) / 2;
            if (target < matrix[midCol][0])
                hi = midCol - 1;
            else if (target > matrix[midCol][0]) 
                lo = midCol + 1;
            else 
                return true;
        }

        if (matrix[midCol][0] > target && midCol >= 1)
            midCol--;
        lo = 0;
        hi = matrix[0].length - 1;
        while (lo <= hi) {
            int midRow = lo + (hi - lo) / 2;
            if (target < matrix[midCol][midRow])
                hi = midRow - 1;
            else if (target > matrix[midCol][midRow])
                lo = midRow + 1;
            else 
                return true;
        }
        return false;
    }
}
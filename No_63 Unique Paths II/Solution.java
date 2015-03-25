public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) { 
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
            
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = (obstacleGrid[0][0] == 1)? 0 : 1;
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1)
                dp[j] = 0;
            else
                dp[j] = dp[j - 1];
        }           
              
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = (obstacleGrid[i][0] == 1)? 0 : dp[0];
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[j] = dp[j - 1] + dp[j];
                else
                    dp[j] = 0;
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
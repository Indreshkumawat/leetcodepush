class Solution {
    // public int solve(int[][] obstacleGrid,int m,int n,int i,int j){
    //     if(i == 0 && j == 0 && obstacleGrid[i][j] != 1){
    //         return 1;
    //     }
    //     if(i < 0 || j < 0){
    //         return 0;
    //     } 
    //     if(obstacleGrid[i][j] != 1){
    //         return solve(obstacleGrid,m,n,i-1,j) + solve(obstacleGrid,m,n,i,j-1);
    //     }
    //     return 0;
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        // return solve(obstacleGrid,m,n,m-1,n-1);
        int dp[][] = new int[m][n];

        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        dp[0][0] = 1;
        for(int i = 1;i<n;i++){
            if(obstacleGrid[0][i] != 1)
               dp[0][i] = dp[0][i-1];
        }
        for(int i = 1;i<m;i++){
            if(obstacleGrid[i][0] != 1)
               dp[i][0] = dp[i-1][0];
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];

    }
}
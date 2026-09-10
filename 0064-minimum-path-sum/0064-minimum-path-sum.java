class Solution {
    int dp[][];
    int solve(int[][] grid,int m,int n,int i,int j){
        if(i == m-1 && j == n-1){
            return dp[i][j] = grid[i][j];
        }
        
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = solve(grid,m,n,i+1,j);
        int b = solve(grid,m,n,i,j+1);

        return dp[i][j] = Math.min(a,b) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(grid,m,n,0,0);
    }
}
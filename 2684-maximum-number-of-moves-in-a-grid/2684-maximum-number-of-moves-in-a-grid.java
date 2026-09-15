class Solution {
    int[][] dp;
    int solve(int[][] grid, int i, int j, int m, int n) {
         if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;

        int[] dr = { -1, 0, 1 };
        int[] dc = { 1, 1, 1 };
        for (int d = 0; d < 3; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];
            if (ni >= 0 && ni < m &&
                    nj < n &&
                    grid[ni][nj] > grid[i][j]) {

                ans = Math.max(
                        ans,
                        1 + solve(grid, ni, nj, m, n));
            }
        }

        return dp[i][j] =  ans;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, solve(grid, i, 0, m, n));
        }

        return ans;

    }
}
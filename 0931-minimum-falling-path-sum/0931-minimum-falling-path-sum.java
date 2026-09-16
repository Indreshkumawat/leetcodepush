class Solution {
    int[][] dp;

    public int solve(int[][] matrix, int i, int j, int m, int n) {
        if (i == m - 1) {
            return dp[i][j] = matrix[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int[] dr = { 1, 1, 1 };
        int[] dc = { -1, 0, 1 };
        int sum = Integer.MAX_VALUE;

        for (int d = 0; d < 3; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];

            if (nj >= 0 && ni < m && nj < n) {
                sum = Math.min(sum, solve(matrix, ni, nj, m, n));
            }
        }

        sum += matrix[i][j];

        return dp[i][j] = sum;
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, solve(matrix, 0, i, m, n));
        }

        return ans;
    }
}
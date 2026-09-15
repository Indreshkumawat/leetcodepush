class Solution {

    int[][] dp;

    int maxValue(List<List<Integer>> grid, int i, int j, int m, int n) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maximum = grid.get(i).get(j);

        if (i + 1 < m) {
            maximum = Math.max(
                maximum,
                maxValue(grid, i + 1, j, m, n)
            );
        }

        if (j + 1 < n) {
            maximum = Math.max(
                maximum,
                maxValue(grid, i, j + 1, m, n)
            );
        }

        return dp[i][j] = maximum;
    }

    int solve(List<List<Integer>> grid, int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return Integer.MIN_VALUE;
        }

        int maximumFuture = Integer.MIN_VALUE;

        if (i + 1 < m) {
            maximumFuture = Math.max(
                maximumFuture,
                maxValue(grid, i + 1, j, m, n)
            );
        }

        if (j + 1 < n) {
            maximumFuture = Math.max(
                maximumFuture,
                maxValue(grid, i, j + 1, m, n)
            );
        }

        return maximumFuture - grid.get(i).get(j);
    }

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(
                    answer,
                    solve(grid, i, j, m, n)
                );
            }
        }

        return answer;
    }
}
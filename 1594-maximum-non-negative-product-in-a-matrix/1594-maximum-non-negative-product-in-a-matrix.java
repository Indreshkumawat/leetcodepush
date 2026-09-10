class Solution {
      class Pair {
        long min;
        long max;

        Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    Pair[][] dp;
    public Pair solve(int[][] grid,int m,int n,int i,int j){
          // Destination
        if(i == m - 1 && j == n - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if(i >= m || j >= n) {
            return null;
        }

          if(dp[i][j] != null) {
            return dp[i][j];
        }


         Pair down = solve(grid, m, n, i + 1, j);
        Pair right = solve(grid, m, n, i, j + 1);

        long minProduct = Long.MAX_VALUE;
        long maxProduct = Long.MIN_VALUE;

        if(down != null) {
            minProduct = Math.min(minProduct,
                    Math.min(
                        grid[i][j] * down.min,
                        grid[i][j] * down.max
                    ));

            maxProduct = Math.max(maxProduct,
                    Math.max(
                        grid[i][j] * down.min,
                        grid[i][j] * down.max
                    ));
        }

        if(right != null) {
            minProduct = Math.min(minProduct,
                    Math.min(
                        grid[i][j] * right.min,
                        grid[i][j] * right.max
                    ));

            maxProduct = Math.max(maxProduct,
                    Math.max(
                        grid[i][j] * right.min,
                        grid[i][j] * right.max
                    ));
        }


        return dp[i][j] = new Pair(minProduct, maxProduct);
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
               dp = new Pair[m][n];

        Pair ans = solve(grid, m, n, 0, 0);

        if(ans.max < 0) {
            return -1;
        }

        return (int)(ans.max % 1000000007);

    }
}
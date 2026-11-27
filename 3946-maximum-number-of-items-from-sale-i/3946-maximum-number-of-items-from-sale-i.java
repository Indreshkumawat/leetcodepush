class Solution {
    int[][][] dp;

    int solve(int idx, int budget, int bought,
              int[][] items, int[] freeCnt) {

        if (idx == items.length) {
            return 0;
        }

        if (dp[idx][budget][bought] != -1) {
            return dp[idx][budget][bought];
        }

        // Choice 1: Skip the current item
        int ans = solve(idx + 1, budget, 0, items, freeCnt);

        int price = items[idx][1];

        // Choice 2: Buy the current item
        if (budget >= price) {

            int gain;

            if (bought == 0) {
                // First purchase: purchased copy + free copies
                gain = 1 + freeCnt[idx];
            } else {
                // Additional purchase: only one purchased copy
                gain = 1;
            }

            ans = Math.max(ans,
                    gain + solve(idx, budget - price, 1,
                                 items, freeCnt));
        }

        return dp[idx][budget][bought] = ans;
    }
    public int maximumSaleItems(int[][] items, int budget) {
         int n = items.length;

        // Precompute free copies for every item
        int[] freeCnt = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % items[i][0] == 0) {
                    freeCnt[i]++;
                }
            }
        }

        dp = new int[n][budget + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= budget; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, budget, 0, items, freeCnt);
    }
}
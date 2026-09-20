class Solution {
    int dp[][];
    int solve(int[] prices,int index,int free){
       if(index == prices.length) {
        return 0;
    }

     if(dp[index][free] != -1){
            return dp[index][free];
        }

    int buy = prices[index] + solve(prices, index + 1, index + 1);

    int takeFree = Integer.MAX_VALUE;

    if(free > 0) {
        takeFree = solve(prices, index + 1, free - 1);
    }

    return dp[index][free] = Math.min(buy, takeFree);
    }
    public int minimumCoins(int[] prices) {
        int n = prices.length;
         dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(prices,0,0);
    }
}
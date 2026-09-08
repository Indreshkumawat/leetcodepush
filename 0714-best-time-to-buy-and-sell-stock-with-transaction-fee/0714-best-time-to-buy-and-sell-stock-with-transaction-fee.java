class Solution {
    int [][]dp;
    int solve(int[] prices, int fee,int index,int k){
        if(index == prices.length){
            return 0;
        }

         if(dp[index][k] != -1){
            return dp[index][k];
        }
        if(k == 2){
            int take = solve(prices,fee,index+1,k-1) - prices[index] - fee;
            int notTake = solve(prices,fee,index+1,k);
            return dp[index][k] =Math.max(take,notTake);
        }else{
            int take = solve(prices,fee,index+1,2) + prices[index];
            int notTake = solve(prices,fee,index+1,k);
            return dp[index][k] = Math.max(take,notTake);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int k = 2;
        dp = new int[prices.length+1][k+1];
       for(int i = 0;i<prices.length +1;i++){
        Arrays.fill(dp[i],-1);
       }
        return solve(prices,fee,0,k);
    }
}
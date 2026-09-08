class Solution {
    int [][]dp;
    int solve(int[] prices,int k,int index){
        if(index >= prices.length){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        if(dp[index][k] != -1){
            return dp[index][k];
        }

        if(k == 2){
            int take = solve(prices,k-1,index+1) - prices[index];
            int notTake = solve(prices,k,index+1);
            return  dp[index][k] = Math.max(take,notTake);
        }else{
            int take = solve(prices,2,index+2) + prices[index];
            int notTake = solve(prices,k,index+1);
            return dp[index][k] = Math.max(take,notTake);
        }
    }
    public int maxProfit(int[] prices) {
        int k = 2;
      dp = new int[prices.length+1][k+1];
       for(int i = 0;i<prices.length +1;i++){
        Arrays.fill(dp[i],-1);
       }
       return solve(prices,k,0);
    }
}
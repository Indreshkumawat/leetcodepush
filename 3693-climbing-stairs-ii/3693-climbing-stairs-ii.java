class Solution {
    int dp[];
    int solve(int[] costs,int step){
        if(step == 0)
           return dp[step] = 0;

        if(dp[step] != -1){
            return dp[step];
        }
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Integer.MAX_VALUE;
        int threeStep = Integer.MAX_VALUE;
        if(step>=1)
        oneStep = costs[step-1] + 1 + solve(costs,step-1);
        if(step>=2)
        twoStep = costs[step-1] + 4 + solve(costs,step-2);
        if(step>=3)
        threeStep = costs[step-1] + 9 + solve(costs,step-3);

        return dp[step] = Math.min(oneStep,Math.min(twoStep,threeStep));
    }
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
    //     Arrays.fill(dp,-1);
    //    return solve(costs,n); 

    for(int i = 1;i<=n;i++){
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Integer.MAX_VALUE;
        int threeStep = Integer.MAX_VALUE;
        if(i>=1)
        oneStep = costs[i-1] + 1 + dp[i-1];
        if(i>=2)
        twoStep = costs[i-1] + 4 + dp[i-2];
        if(i>=3)
        threeStep = costs[i-1] + 9 + dp[i-3];
        dp[i] = Math.min(oneStep,Math.min(twoStep,threeStep));
    }
    return dp[n];
    }
}
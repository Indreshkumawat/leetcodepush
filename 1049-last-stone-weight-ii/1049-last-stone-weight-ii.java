class Solution {
    int dp[][];
    int solve(int[] stones,int n,int target){
        if(n < 0){
            return 0;
        }
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int take = 0;
        if(stones[n] <= target){
            take = stones[n] + solve(stones,n-1,target-stones[n]);
        }
        int notTake = solve(stones,n-1,target);
        return dp[n][target] = Math.max(take,notTake);
    }
    public int lastStoneWeightII(int[] stones) {
        int s  = 0;
        for(int i = 0;i<stones.length;i++){
            s += stones[i];
        }
        int n = stones.length;
        int target = s/2;

        dp = new int[n][target+1];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int s2 = solve(stones,n-1,target);

        return (s - (2*s2));
    } 
}
class Solution {
    int dp[][];
    int solve(int [][]player,int n,int prevIndex){
        if(n < 0){
            return 0;
        }
        if(dp[n][prevIndex+1] != -1){
            return dp[n][prevIndex +1];
        }
        int take = 0;
        if(prevIndex == -1 || player[n][0] <= player[prevIndex][0]){
            take = player[n][0] + solve(player,n-1 ,n);
        }

        int notTake =solve(player,n-1,prevIndex);

        return dp[n][prevIndex+1] =  Math.max(take,notTake);

    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int [][]player = new int[n][2];

        for(int i = 0;i<n;i++){
            player[i][0] = scores[i];
            player[i][1] = ages[i];
        }

        Arrays.sort(player,(a,b)->{
            if(a[1] == b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });

        dp = new int[n][n+1];

          for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        return solve(player,n-1,-1);

    }
}
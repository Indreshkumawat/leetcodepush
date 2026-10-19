class Solution {
    int dp[][];
    int solve(String s1, String s2,int i,int j){
        if(i < 0 && j < 0){
            return 0;
        }
        if(i < 0){
            int sum = 0;
            for(int k = j;k>=0;k--){
                sum += (int)s2.charAt(k);
            }
            return sum;
        }
        if(j < 0){
             int sum = 0;
            for(int k = i;k>=0;k--){
                sum += (int)s1.charAt(k);
            }
            return sum;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1,s2,i-1,j-1);
        }else{
            int take = (int)s1.charAt(i) + solve(s1,s2,i-1,j);
            int notTake = (int)s2.charAt(j) + solve(s1,s2,i,j-1);
            return dp[i][j] = Math.min(take,notTake);
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        dp = new int[m][n];

        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(s1,s2,m-1,n-1);

        // int dp[][] = new int[m+1][n+1];

        // for(int i = 1;i<m+1;i++){
        //     for(int j =1;j<n+1;j++){
        //         if(s1[i-1] == s2[j-1]){
        //             dp[i][j] = 1 + d[i-1][j-1];
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }
    }
}
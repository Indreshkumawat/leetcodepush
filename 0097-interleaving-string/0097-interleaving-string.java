class Solution {
    int m;
    int n;
    int o;
   // Boolean dp[][][];

    // boolean solve(String s1, String s2, String s3,int i,int j,int k){
    //     if( i == m && j == n && k == o){
    //         return true;
    //     }
    //     if(dp[i][j][k] != null){
    //         return dp[i][j][k];
    //     }
    //     boolean take1 = false;
    //     boolean take2 = false;
    //     if(i < m && s1.charAt(i) == s3.charAt(k)){
    //         take1 = solve(s1,s2,s3,i+1,j,k+1);
    //     }
    //     if(j < n && s2.charAt(j) == s3.charAt(k)){
    //         take2 = solve(s1,s2,s3,i,j+1,k+1);
    //     }
    //     return dp[i][j][k] = take1 || take2;
    // }
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        o = s3.length();

        if (m + n != o) {
            return false;
        }

       // dp = new Boolean[m + 1][n + 1][o + 1];

        //return solve(s1, s2, s3, 0, 0, 0);


        boolean[][][] dp = new boolean[m + 1][n + 1][o + 1];
        dp[0][0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j;

                if (k > o) {
                    continue;
                }

                if (i > 0 &&
                    s1.charAt(i - 1) == s3.charAt(k - 1)) {
                    dp[i][j][k] = dp[i-1][j][k-1];
                }

                if (j > 0 &&
                    s2.charAt(j - 1) == s3.charAt(k - 1)) {
                    dp[i][j][k] = dp[i][j][k] || dp[i][j - 1][k - 1];
                }
            }
        }

        return dp[m][n][o];
    }
}
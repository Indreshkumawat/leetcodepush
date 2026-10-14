class Solution {
    public int minInsertions(String s) {
        StringBuilder str = new StringBuilder(s);
        str = str.reverse();
        int m = s.length();
        int n = str.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return m - dp[m][n];
    }
}
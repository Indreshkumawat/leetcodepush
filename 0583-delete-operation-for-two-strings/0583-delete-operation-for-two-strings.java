class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i = 1;i<m+1;i++){
            for(int j = 1;j < n+1;j++){
                int take = 0;
                int take1 = 0;
                int take2 = 0;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    take = 1 + dp[i-1][j-1];
                }
                else
                {
                    take1 = dp[i-1][j];
                    take2 =dp[i][j-1];
                }
                dp[i][j] = Math.max(take,Math.max(take1,take2));
            }
        }

        return m + n - (2*dp[m][n]);
    }
}
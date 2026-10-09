class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s1 = new StringBuilder(s);

        s1.reverse();

        String str = s1.toString();


         int m =s.length();
        int dp[][] = new int[m+1][m+1];

        for(int i = 1;i<m+1;i++){
            for(int j = 1;j < m+1;j++){
                int take = 0;
                int take1 = 0;
                int take2 = 0;
                if(s.charAt(i-1) == str.charAt(j-1)){
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

        return dp[m][m];
    }
}
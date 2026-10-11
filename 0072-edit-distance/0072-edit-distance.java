class Solution {
    int m;
    int n;
    int dp[][];
    // int solve(String word1, String word2,int i,int j){
    //     if( i < 0){
    //         return j+1;
    //     } 
    //     if(j < 0){
    //         return i+1;
    //     }

    //     if(word1.charAt(i) != word2.charAt(j)){
    //         int insert = 1 + solve(word1,word2,i,j-1);
    //         int del = 1 + solve(word1,word2,i-1,j);
    //         int replace = 1 + solve(word1,word2,i-1,j-1);
    //         return  Math.min(insert,Math.min(del,replace));
    //     }else{
    //         return solve(word1,word2,i-1,j-1);
    //     }
    // }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
       // return solve(word1, word2, m - 1, n - 1);

        dp = new int[m + 1][n + 1];

        for (int i = 1; i < n+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m+1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    int insert = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] =  Math.min(insert, Math.min(del, replace));
                } else {
                    dp[i][j] =  dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
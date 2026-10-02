class Solution {
    int dp[][];
    int solve(String text1, String text2,int m,int n,int i,int j){
        if(i >= m || j >= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = 0;
        int take1 = 0;
        int take2 = 0;

        if(i < m && j < n && text1.charAt(i) == text2.charAt(j)){
            take = 1 + solve(text1,text2,m,n,i+1,j+1);
        }
        else{
            take1 = solve(text1,text2,m,n,i,j+1);
            take2 = solve(text1,text2,m,n,i+1,j);
        }
        return dp[i][j] = Math.max(take,Math.max(take1,take2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(text1,text2,m,n,0,0);
    }
}
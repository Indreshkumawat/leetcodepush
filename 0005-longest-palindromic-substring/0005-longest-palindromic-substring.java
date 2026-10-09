class Solution {
    boolean dp[][];
    boolean solve(String s,int i,int j){
        if(i >= j){
            return dp[i][j] = true;
        }
        if(dp[i][j] != false){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(s,i+1,j-1);
        }

        return dp[i][j] = false;
        
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        int maxLen = 0;
        int pos = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(solve(s,i,j)){
                    if(j-i+1 > maxLen){
                        maxLen = j - i + 1;
                        pos = i;
                    }
                   
                }
            }
        }

        return s.substring(pos,pos+maxLen);
    }
}
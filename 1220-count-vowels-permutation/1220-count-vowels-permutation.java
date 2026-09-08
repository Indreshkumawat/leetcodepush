class Solution {
    int MOD = 1000000007;
    long dp[][];
    int a = 0 , e = 1, i = 2, o = 3, u = 4;
    long solve(int n,int ch){
        if(n == 0){
            return 1;
        }
        if(dp[ch][n] != -1){
            return dp[ch][n];
        }
        if(ch == a){
            return dp[ch][n] = solve(n-1,e)%MOD;
        }else if(ch == e){
            return dp[ch][n] = (solve(n-1,a)+ solve(n-1,i))%MOD;            
        }
        else if(ch == i){
            return dp[ch][n] = (solve(n-1,a)+ solve(n-1,e) + solve(n-1,o) + solve(n-1,u))%MOD;
        }
        else if(ch == o){
            return dp[ch][n] = (solve(n-1,i) + solve(n-1,u))%MOD; 
        }else{
            return dp[ch][n] = solve(n-1,a)%MOD;
        }
    }
    public int countVowelPermutation(int n) {
        dp = new long [5][n+1];
        for(int i = 0;i<5;i++){
            Arrays.fill(dp[i],-1);
        }
        return (int)((solve(n-1,a) + solve(n-1,e) + solve(n-1,i) +
        solve(n-1,o) + solve(n-1,u))%MOD);
    }
}
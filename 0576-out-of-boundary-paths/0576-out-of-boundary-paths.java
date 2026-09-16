class Solution {
    int [][][]dp;
    int MOD = 1000000007;
    public int solve(int m, int n, int maxMove, int i, int j){
        if(i>=m || i < 0 || j >= n || j < 0){
            return 1;
        }
        if(dp[maxMove][i][j] != -1){
            return dp[maxMove][i][j];
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        int ans = 0;
        for(int d = 0;d<4;d++){
            int ni = i + dr[d];
            int nj = j + dc[d];
            if(maxMove>0){
                 ans = (ans + solve(m,n,maxMove-1,ni,nj))%MOD ;
             }
             else{
                break;
            }
        }
        return dp[maxMove][i][j] = ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[maxMove+1][m][n];
         for (int move = 0; move <= maxMove; move++) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[move][i], -1);
            }
        }
        return solve(m,n,maxMove,startRow,startColumn);
    }
}
class Solution {
    int dp[][][];
    int solve(int []ones,int []zeros,int size,int m,int n){
        if((size < 0) || (m == 0 && n == 0)){
            return 0;
        }

        if(dp[size][m][n] != -1){
            return dp[size][m][n];
        }

        int take = 0;
        if(m >= zeros[size] && n >= ones[size]){
            take =  1 + solve(ones,zeros,size-1,m - zeros[size],n - ones[size]);
        }

        int notTake = solve(ones,zeros,size-1,m,n);

        return dp[size][m][n] = Math.max(take,notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int []ones = new int[size];
        int []zeros = new int[size];
        for(int i = 0;i<size;i++){
            int oneCount  = 0;
            int zeroCount = 0;
            for(char ch : strs[i].toCharArray()){
                if(ch == '1'){
                    oneCount++;
                }else{
                    zeroCount++;
                }
            }
            ones[i] = oneCount;
            zeros[i] = zeroCount;
        }

        dp = new int[size][m+1][n+1]; 

        for(int i = 0;i<size;i++){
            for(int j = 0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(ones,zeros,size-1,m,n);
    }
}
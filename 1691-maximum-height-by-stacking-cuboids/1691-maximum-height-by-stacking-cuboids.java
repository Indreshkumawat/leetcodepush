class Solution {
    public int maxHeight(int[][] cuboids) {
          int n = cuboids.length;
        int dp[] = new int[n];        
        for(int i = 0;i<n;i++){
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids,(a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[2],b[2]);
            }
        });

         int maxi = 1;

        for(int i = 0;i<n;i++){
            dp[i] = cuboids[i][2];
            for(int j = 0;j<i;j++){
                if(cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2] ){
                    dp[i] = Math.max(dp[i],dp[j] + cuboids[i][2]);
                    
                }
            }
            maxi = Math.max(dp[i],maxi);
        }

        return maxi;

        

    }
}
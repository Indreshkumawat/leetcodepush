class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(b[1],a[1]);
            }
        });

        // int maxi = 1;

        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<i;j++){
        //         if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
        //             dp[i] = Math.max(dp[i],dp[j] +1);
        //             maxi = Math.max(dp[i],maxi);
        //         }
        //     }
        // }

        // return maxi;


        

        int[] lis = new int[n];
        int size = 0;

        for(int  i = 0;i<n;i++){
            int val = envelopes[i][1];
            int s = 0;
            int e = size;
            while(s < e){
                  int mid = s + (e - s) / 2;

                if(lis[mid] < val) {
                    s = mid + 1;
                }
                else {
                    e = mid;
                }
            }
            lis[s] = val;
            if(s == size) {
                size++;
            }

        }
        return size;
    }
}
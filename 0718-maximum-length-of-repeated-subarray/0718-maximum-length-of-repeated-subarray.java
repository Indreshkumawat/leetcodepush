class Solution {
    int m;
    int n;
    int dp[][];
    int solve(int[] nums1, int[] nums2,int i,int j){
        if(i >= m || j >= n ){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(nums1,nums2,i+1,j+1);
        }
        return dp[i][j] = 0;
    }
    public int findLength(int[] nums1, int[] nums2) {
      m = nums1.length;
      n = nums2.length;
        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
    int maxLen = 0;
    for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++)
        {
            if(nums1[i] == nums2[j]){
                // int count = 0;
                // int k = i;
                // int w = j;
                // while(k < m && w < n && nums1[k] == nums2[w]){
                //     count++;
                //     k++;
                //     w++;
                // }
                maxLen = Math.max(maxLen,solve(nums1,nums2,i,j));
            }
        }
    }

    return maxLen;
    }
}
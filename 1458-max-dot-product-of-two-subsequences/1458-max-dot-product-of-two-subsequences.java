class Solution {
    int m;
    int n;
    int dp[][];
    int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == m || j == n) {
            return Integer.MIN_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int product = nums1[i] * nums2[j];
         
        int take = product;
        int next = solve(nums1, nums2, i + 1, j + 1);

        if (next != Integer.MIN_VALUE) {
            take = Math.max(take, product + next);
        }
        int notTake1 = solve(nums1, nums2, i, j + 1);
        int notTake2 = solve(nums1, nums2, i + 1, j);
        return dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m+1][n+1];
        for(int i = 0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(nums1, nums2, 0, 0);
    }
}
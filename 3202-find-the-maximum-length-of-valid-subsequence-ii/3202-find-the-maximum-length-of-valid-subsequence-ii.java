class Solution {
    public int maximumLength(int[] nums, int k) {

        int dp[][] = new int[k][nums.length];

        for(int i = 0;i<k;i++){
            Arrays.fill(dp[i],1);
        }

        int maxi = 0;

        for (int i = 0; i<nums.length; i++) {
			int j = 0;
			while (j<i) {
                int mod = (nums[i]+nums[j])%k;
                dp[mod][i] = Math.max(dp[mod][i],1+dp[mod][j]);
                maxi = Math.max(dp[mod][i],maxi);
                j++;
			}
				
		}
        return maxi;
	}
}
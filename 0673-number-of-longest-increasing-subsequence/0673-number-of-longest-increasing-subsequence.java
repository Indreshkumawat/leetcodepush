class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int arr[] = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(arr,1);
        int maxi = 1;
        for(int i = 0;i<nums.length;i++){
            int j = 0;
            while(j<i){
                if(nums[i]>nums[j]){
                    if(dp[j] + 1 >dp[i]){
                        dp[i] = dp[j] + 1;
                        arr[i] = arr[j];
                    } else if(dp[j] + 1 == dp[i]){
                        arr[i] += arr[j];
                    }
                    maxi = Math.max(dp[i],maxi);
                }
                j++;
            }
        }

        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(dp[i] == maxi)
            ans += arr[i];
        }   
        return ans;
    }
}
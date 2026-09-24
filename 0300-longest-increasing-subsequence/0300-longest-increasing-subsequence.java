class Solution {
    // int dp[][];
    // int solve(int[] nums,int index,int preIndex){
    //     if(index < 0){
    //         return 0;
    //     }
    //     if(dp[index][preIndex] != -1){
    //         return dp[index][preIndex];
    //     }
    //     int take = 0;
    //     int notTake = 0;
    //     if(preIndex == nums.length || nums[index] < nums[preIndex]){
    //         take = 1 + solve(nums,index - 1,index);
    //     }
    //     notTake = solve(nums,index-1,preIndex);
    //     return dp[index][preIndex] = Math.max(take,notTake);
    // }
    public int lengthOfLIS(int[] nums) {
        // int size = nums.length;
        // dp = new int[size][size+1];
        // for(int i = 0;i<size;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        // return solve(nums,size-1,size);

        int dp[] = new int[nums.length];

        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 0;i<nums.length;i++){
            int j = 0;
            while(j<i){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxi = Math.max(dp[i],maxi);
                }
                j++;
            }
        }

        

        return maxi;
    }
}
class Solution {
    public int maximumDifference(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];
        int ans = 0;

        for(int i = 1;i<nums.length;i++){
           if(nums[i] < mini){
            ans = Math.max(maxi-mini,ans);
            mini = nums[i];
            maxi = nums[i];

           }else if(nums[i] > maxi){
            maxi = nums[i];
           }
        }
        ans = Math.max(maxi-mini,ans);

        return ans == 0 ? -1 : ans;
    }
}
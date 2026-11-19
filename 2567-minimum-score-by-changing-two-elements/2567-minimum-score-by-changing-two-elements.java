class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int temp1 = nums[n-1] - nums[2];

        int temp2 = nums[n-3] - nums[0];

        int temp3 = nums[n-2] -  nums[1];

        return Math.min(temp1,Math.min(temp2,temp3));
    }
}
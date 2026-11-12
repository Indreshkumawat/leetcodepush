class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1)
        {
            return 1;
        }
        int increaseCount = 1;
        int decreaseCount = 1;
        int maxIncCount = 0;
        int maxDecCount = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums [ i-1]){
                increaseCount++;
            }
            else{
                maxIncCount = Math.max(increaseCount , maxIncCount);
                increaseCount = 1;
            }
        }
        if(increaseCount > maxIncCount){
           maxIncCount = increaseCount; 
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums [ i-1]){
                decreaseCount++;
            }
            else{
                maxDecCount = Math.max(decreaseCount , maxDecCount);
                decreaseCount = 1;
            }
        }

         if(decreaseCount > maxDecCount){
           maxDecCount = decreaseCount; 
        }

        return Math.max(maxIncCount,maxDecCount);


    }
}
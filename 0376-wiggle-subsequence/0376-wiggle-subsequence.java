class Solution {
    public int wiggleMaxLength(int[] nums) {
       
        int negativeEnd[] = new int[nums.length];
        int positiveEnd[] = new int[nums.length];

        Arrays.fill(negativeEnd,1);
        Arrays.fill(positiveEnd,1);

        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    positiveEnd[i] = Math.max(positiveEnd[i],negativeEnd[j] +1);

                }else if(nums[i] <nums[j]){
                    negativeEnd[i] = Math.max(negativeEnd[i],positiveEnd[j] +1);
                }
            }
        }
        int ans = 1;
        for(int i = 0;i<nums.length;i++){
            ans= Math.max(ans,Math.max(negativeEnd[i],positiveEnd[i]));
        }
        return ans;

    }
}
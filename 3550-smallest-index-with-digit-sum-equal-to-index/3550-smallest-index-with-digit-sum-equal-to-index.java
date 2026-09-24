class Solution {
    public int smallestIndex(int[] nums) {
        int res = -1;
        for(int i = nums.length-1;i>=0;i--){
            int temp = nums[i];
            int sum = 0;
            while(temp > 0){
                int digit  = temp%10;
                sum += digit;
                temp /= 10;
            }
            if(sum == i){
                res = i;
            }
        }

        return res;
    }
}
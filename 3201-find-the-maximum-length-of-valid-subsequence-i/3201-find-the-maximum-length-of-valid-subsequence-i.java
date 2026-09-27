class Solution {
    public int maximumLength(int[] nums) {
         int even = 0;
         int odd = 0;

        for(int num : nums){
            if(num%2 == 0){
                even++;
            }else{
                odd++;
            }
        }

        int altEven = 0;
        boolean needEven = true;
        for(int num : nums){
            if(needEven && num%2 == 0){
                altEven++;
                needEven = false;
            }else if(!needEven && num%2 != 0){
                altEven++;
                needEven = true;
            }
        } 
        int altOdd = 0;
        boolean needOdd = true;
        for(int num : nums){
            if(needOdd && num%2 != 0){
                altOdd++;
                needOdd = false;
            }else if(!needOdd && num%2 == 0){
                altOdd++;
                needOdd = true;
            }
        } 

        return Math.max(Math.max(odd,even),Math.max(altEven,altOdd));
    }
}
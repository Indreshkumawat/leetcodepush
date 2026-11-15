class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int evenCount = 1;
        int oddCount = 0;
        int result = 0;
        int preSum = 0;
        for(int i = 0;i<arr.length;i++){
            preSum += arr[i];

            if(preSum % 2 == 0){
                result = (result + oddCount) % MOD;
                evenCount++;
            }
            else{
                result = (result + evenCount) % MOD;
                oddCount++;
            }

        }
        
        return result;
    }
}
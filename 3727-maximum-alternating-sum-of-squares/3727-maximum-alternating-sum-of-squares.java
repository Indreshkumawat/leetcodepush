class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(Math.abs(a), Math.abs(b));
        });
        int i = 0;
        int j = nums.length-1;
        long ans = 0;

        while(i < j){
            ans += (arr[j]*arr[j] - arr[i]*arr[i]);
            i++;
            j--;
        }
        if( i == j){
            ans += arr[i]*arr[i];
        }

        return ans;
    }
}
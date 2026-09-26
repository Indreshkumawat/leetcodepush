class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int parent[] = new int[n];
        int maxi = 1;
        int index = 0;

        for(int i = 0;i<n;i++){
            parent[i] = -1;
            for(int j = 0;j<i;j++){
                if(nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0  ){

                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
             if(maxi < dp[i]){
                        maxi = dp[i];
                        index = i;
                    }
        }

        List<Integer> ans  = new ArrayList<>();

        while(index != -1){
            ans.add(nums[index]);
            index = parent[index];
        }
        Collections.reverse(ans);

        return ans;
    }
}
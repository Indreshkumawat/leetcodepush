class Solution {
public:
    int solve(vector<int>& nums,int index,vector<int> &dp){
        if(index == nums.size()-1){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int ans = INT_MAX;
        for(int i = 0;i<nums[index] && index + i +1 < nums.size();i++){
            int count = solve(nums,index+i+1,dp);
            if(count!=INT_MAX)
            ans = min(ans,count+1);
        }
        return dp[index] = ans;
    }
    int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1,-1);
        int index = 0;
        return solve(nums,index,dp);
    }
};
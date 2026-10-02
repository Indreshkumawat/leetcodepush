class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans[] = new int[2];

        for(int  i = 0;i<nums.length;i++){
            int comp = target - nums[i];

            if(mp.containsKey(comp)){
                ans[0] = mp.get(comp);
                ans[1] = i;
                return ans;
            }

            mp.put(nums[i],i);
        }

        return ans;
        
    }
}
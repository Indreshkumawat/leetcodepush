class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans[] =  nums.clone();

        for(int i = 0;i<nums.length;i++){
            mp.put(nums[i],i);
        }

        for(int x[] : operations){
            int index = mp.get(x[0]);
            mp.remove(x[0]);

            ans[index] = x[1];
            mp.put(ans[index],index);
        }

        return ans;
    }
}
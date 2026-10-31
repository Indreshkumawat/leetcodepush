class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0) +1 );
        }

        int ans = 0;

        for(Map.Entry<Integer,Integer> m : mp.entrySet()){
            if(m.getValue() == 1){
                ans += m.getKey();
            }
        }

        return ans;
    }
}
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         HashMap<Integer,Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0) +1 );
        }

        List<Integer> ans =  new ArrayList<>();

        for(Map.Entry<Integer,Integer> m : mp.entrySet()){
            if(m.getValue() == 2){
                ans.add(m.getKey());
            }
        }

        return ans;

    }
}
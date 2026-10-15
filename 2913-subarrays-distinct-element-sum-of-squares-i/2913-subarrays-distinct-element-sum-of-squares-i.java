class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(); 
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(!set.contains(nums.get(j))){
                    set.add(nums.get(j));
                }
                int count = set.size();
                sum += count*count;
            }
            set.clear();
        }

        return sum;
    }
}
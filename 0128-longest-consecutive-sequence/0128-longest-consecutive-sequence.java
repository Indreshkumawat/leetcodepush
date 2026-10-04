class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        
        int longest = 0;
        for(int num : set){
            int count = 1;
            if(!set.contains(num-1)){
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                longest = Math.max(count,longest);
            }
        }

        return longest;
    }
}
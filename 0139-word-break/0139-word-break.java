class Solution {
    Boolean dp[];
    boolean solve(String s,int ind,HashSet<String> set){
        if(ind == s.length()){
            return dp[ind] = true;
        }

        if(dp[ind] != null){
            return dp[ind];
        }
        
        for(int end = ind + 1;end<=s.length();end++){
            String word = s.substring(ind,end);

            if(set.contains(word)){
                if(solve(s,end,set)){
                    return dp[ind] = true;
                }
            }
        }
        return dp[ind] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        dp = new Boolean[s.length() + 1];
        Arrays.fill(dp,null);
        return solve(s,0,set);
    }
}
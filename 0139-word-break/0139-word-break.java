class Solution {
    // Boolean dp[];
    // boolean solve(String s,int ind,HashSet<String> set){
    //     if(ind == s.length()){
    //         return dp[ind] = true;
    //     }

    //     if(dp[ind] != null){
    //         return dp[ind];
    //     }
        
    //     for(int end = ind + 1;end<=s.length();end++){
    //         String word = s.substring(ind,end);

    //         if(set.contains(word)){
    //             if(solve(s,end,set)){
    //                 return dp[ind] = true;
    //             }
    //         }
    //     }
    //     return dp[ind] = false;
    // }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for(int i = 1; i <= n; i++) {

            for(int j = 0; j < i; j++) {

                if(dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
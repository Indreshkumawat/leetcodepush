class Solution {
    // int dp[];
    // int solve(String s, int index) {
    //     if (index == s.length()) {
    //         return 0;
    //     }

    //     if(dp[index] != -1){
    //         return dp[index];
    //     }

    //     HashMap<Character, Integer> mp = new HashMap<>();
    //     int ans = Integer.MAX_VALUE;
    //     int maxFreq = 0;

    //     for (int end = index; end < s.length(); end++) {
    //         char ch = s.charAt(end);

    //         mp.put(ch, mp.getOrDefault(ch, 0) + 1);
    //         maxFreq = Math.max(maxFreq, mp.get(ch));

    //         if (check(mp, maxFreq)) {
    //             ans = Math.min(ans, 1 + solve(s, end + 1));
    //         }
    //     }

    //     return dp[index] = ans;
    // }

    // boolean check(HashMap<Character, Integer> mp, int maxFreq) {
    //     for (int freq : mp.values()) {
    //         if (freq != maxFreq) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

     boolean check(HashMap<Character, Integer> mp, int maxFreq, int len) {
        return mp.size() * maxFreq == len;
    }

    public int minimumSubstringsInPartition(String s) {
        // dp = new int[s.length()+1];
        // Arrays.fill(dp,-1);
        // return solve(s, 0);

        int n = s.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            HashMap<Character, Integer> mp = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j >= 1; j--) {
                char ch = s.charAt(j - 1);

                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
                maxFreq = Math.max(maxFreq, mp.get(ch));

                int len = i - j + 1;

                if (check(mp, maxFreq, len)) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n];
    }
}
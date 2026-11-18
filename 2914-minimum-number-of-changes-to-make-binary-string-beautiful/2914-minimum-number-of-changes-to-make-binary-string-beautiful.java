class Solution {
    public int minChanges(String s) {
       int ans = 0;
       int i = 0;
        while(i<s.length()){
            if((s.charAt(i) == '1' && s.charAt(i+1) =='0') ||
            (s.charAt(i) == '0' && s.charAt(i+1) =='1')){
                ans++;
            }
            i += 2;
        }

        return ans;
    }
}
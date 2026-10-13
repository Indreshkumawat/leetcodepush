class Solution {
    int m;
    int n;
    boolean solve(String s, String p,int i,int j){
        if(j == n ){
            if(i == m){
                return true;
            }
            return false;
        }

        if(j + 1 < n && p.charAt(j + 1) == '*'){
            boolean notTake = solve(s,p,i,j+2);
            boolean take = false;
            if(i < m && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
                take = solve(s,p,i+1,j);
            }
            return notTake || take;

        }else{
            if(i<m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
              return solve(s,p,i+1,j+1);
            }

            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        return solve(s,p,0,0);
    }
}
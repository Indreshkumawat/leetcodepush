class Solution {
    public int scoreOfParentheses(String s) {
        int open = 0;
        int res = 0;
        for(int  i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else{
                if(s.charAt(i-1) == '('){
                    res += Math.pow(2,open-1);
                }
                open--;
            }
        }

        return res;
    }
}
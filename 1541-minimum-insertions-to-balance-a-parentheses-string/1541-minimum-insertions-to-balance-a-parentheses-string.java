class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int i  = 0;
        int ans = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
                i++;
            } else { 
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                   
                    if (stack.isEmpty()) {
                        ans++;
                    } else {
                        stack.pop();
                    }
                    i += 2; 
                } else {
                    if (stack.isEmpty()) {
                        ans += 2; 
                    } else {
                        stack.pop();
                        ans += 1; 
                    }
                    i++;
                }
            }
        }

        if(stack.size() > 0){
            ans += stack.size()*2;
        }

        return ans;
        
    }
}
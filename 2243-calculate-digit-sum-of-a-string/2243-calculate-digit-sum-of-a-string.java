class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k){
            return s;
        }
        StringBuilder temp = new StringBuilder(s);
        
       
        while(temp.length() > k){
            StringBuilder str = new StringBuilder();
            int i = 0;
            int kCount = 0;
            int sum = 0;
            while(i < temp.length()){
                char ch = temp.charAt(i);
                sum += (ch - '0');
                kCount++;
                if(kCount == k || i == temp.length()-1){
                    kCount = 0;
                    str.append(Integer.toString(sum));
                    sum = 0;
                }
                i++;
            }
            temp = str;
        }

        return temp.toString();
    }
}
class Solution {
    public boolean checkString(String s) {
        boolean bOcc = false;

        for(char ch : s.toCharArray()){
            if(ch == 'a' && bOcc == true){
                return false;
            }
            if(ch == 'b')
              bOcc = true;
        }

        return true;
    }
}
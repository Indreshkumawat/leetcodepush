class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        if(9*num < sum){
            return "";
        }
        int count = num;
        int tempSum = sum;
        while(count > 0){
            if(count == 1){
                int val = tempSum;
                ans.append(String.valueOf(val));
                return ans.toString();
            }
            if(tempSum >= 9){
                tempSum -= 9;
                ans.append("9");
            }else{
                String temp = String.valueOf(tempSum);
                tempSum -= tempSum;
                ans.append(temp);
            }
            
            count--;
        }

        return ans.toString();
    }
}
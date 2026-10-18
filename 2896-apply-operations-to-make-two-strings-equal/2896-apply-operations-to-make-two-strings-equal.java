class Solution {
    double dp[];
    double solve(ArrayList<Integer> arr,int index,int x){
        if(index == arr.size()){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        double take = x/2.0 + solve(arr,index+1,x);

        double take2 = Integer.MAX_VALUE;

        if(index + 1 < arr.size()){
            take2 = arr.get(index + 1) - arr.get(index) + solve(arr,index + 2,x);
        }
        return dp[index] = Math.min(take,take2);
    }
    public int minOperations(String s1, String s2, int x) {

        ArrayList<Integer> arr = new ArrayList<>();
        

        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                arr.add(i);
            }
        }

        if(arr.size() %2 != 0){
            return -1;
        }

        dp = new double[arr.size()+1];
        Arrays.fill(dp,-1);

        return (int)solve(arr,0,x);
    }
}
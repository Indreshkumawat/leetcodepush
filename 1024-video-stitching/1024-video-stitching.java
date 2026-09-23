class Solution {
    int size;
    int dp[][];
    int solve(int[][] clips,int n,int limit,int time){
        if(limit >= time){
            return 0;
        }
        if(n == size){
             return 1000000;
        }

        if(dp[n][limit] != -1){
            return dp[n][limit];
        }

        int take = 1000000;
        int notTake = 1000000;

        if(clips[n][0] <= limit && limit < clips[n][1]){
            take = 1 + solve(clips,n+1,clips[n][1],time);
        }
        notTake = solve(clips,n+1,limit,time);

        return dp[n][limit] = Math.min(take,notTake);
    }
    public int videoStitching(int[][] clips, int time) {
        size = clips.length;
        Arrays.sort(clips,(a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }

        });

        dp = new int[size+1][time+1];
         for(int i = 0;i<size+1;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = solve(clips,0,0,time);

        return ans >= 1000000 ? -1 : ans;
    }
}
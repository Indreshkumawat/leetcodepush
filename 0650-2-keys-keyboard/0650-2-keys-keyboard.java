class Solution {
    int solve(int n,int screen,int clipboard){
        if(screen == n){
            return 0;
        }
        if(screen > n){
            return 1000000;
        }
        int copy = 1000000;
        int paste = 1000000;
        if(screen != clipboard){
            copy = 1 + solve(n,screen,screen);
        }
        if(clipboard > 0){
            paste = 1 + solve(n,screen+clipboard,clipboard);
        }

        return Math.min(copy,paste);
        
    }
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return solve(n,1,0);
    }
}
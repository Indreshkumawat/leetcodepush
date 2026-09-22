class Solution {
    int width;
    int dp[][];
    int solve(int[][] books, int remWidth,int n,int maxHeight){
        if(n < 0){
            return maxHeight;
        }

        if(dp[n][remWidth] != -1){
            return dp[n][remWidth];
        }

        int takeShelf = Integer.MAX_VALUE;

        if(books[n][0] <= remWidth){
            takeShelf = solve(books,remWidth-books[n][0],n-1,Math.max(maxHeight,books[n][1]));
        }
        int skipShelf = maxHeight + solve(books,width-books[n][0],n-1,books[n][1]);

        return dp[n][remWidth] = Math.min(takeShelf,skipShelf);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        width = shelfWidth;
        dp = new int[n+1][width+1];
        for(int i = 0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
       return  solve(books,width,n-1,0);
    }
}
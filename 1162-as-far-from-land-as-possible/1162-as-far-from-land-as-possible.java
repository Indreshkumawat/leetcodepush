class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        if(q.isEmpty() || q.size() == n*n){
            return -1;
        }

        int dist = 0;

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0}; 

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                Pair p = q.poll();

                int x = p.x;
                int y = p.y;

                for(int i = 0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == false){
                        visited[nx][ny] = true;
                        q.add(new Pair(nx,ny));
                    }
                }

                size--;
            }
            dist++;
        }
        return dist-1;
    }
}
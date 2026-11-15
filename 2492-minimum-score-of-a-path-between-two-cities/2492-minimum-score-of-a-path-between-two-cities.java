class Solution {
    class Pair{
        int y;
        int d;
        Pair(int y,int d){
            this.y = y;
            this.d = d;
        }
    }
    int minPath = Integer.MAX_VALUE;

    void dfs(List<List<Pair>> adj,int n,int src,boolean visited[]){
       
        visited[src] = true;
        List<Pair> temp = adj.get(src); 
        for(Pair p : temp){
            minPath = Math.min(minPath,p.d);
            if(!visited[p.y]){
                dfs(adj,n,p.y,visited);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        int m = roads.length;
        boolean visited[] = new boolean[n+1];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int dist = roads[i][2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        dfs(adj,n,1,visited);

        return minPath;
    }
}
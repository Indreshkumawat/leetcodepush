class Solution {
    int ans = 0;
     void dfs(List<List<int []>> adj,int src,boolean visited[]){
        visited[src] = true;
        List<int []> temp = adj.get(src);

        for(int i = 0;i<temp.size();i++){
            int []neigh = temp.get(i);
            if(!visited[neigh[0]]){
                if(neigh[1] == 1){
                    ans++;
                }
                dfs(adj,neigh[0],visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
         boolean visited[] = new boolean[n];
        List<List<int[]>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i= 0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }
        
        dfs(adj,0,visited);

        return ans;
    }
}
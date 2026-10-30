class Solution {
    int vertices;
    int totalEdges;
    void dfs(List<List<Integer>> adj,int src,boolean visited[]){
        visited[src] = true;
        vertices++;
        List<Integer> temp = adj.get(src);
        totalEdges += temp.size();
        for(int i = 0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                dfs(adj,temp.get(i),visited);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i= 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = 0;

        for(int i = 0;i<n;i++){
            vertices = 0;
            totalEdges = 0;

            if(!visited[i]){
                dfs(adj,i,visited);
                int edgeCount = totalEdges/2;

                if(edgeCount == vertices*(vertices-1)/2){
                    ans++;
                }
            }
        }

        return ans;
    }
}
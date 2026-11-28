class Solution {
    boolean bfs(int[][] graph,int src,int color[],Queue<Integer> q){
        q.add(src);
        color[src] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neigh : graph[node]){
                if(color[neigh] == -1){
                    color[neigh] = 1 - color[node];
                    q.add(neigh);
                }
                else if(color[neigh] == color[node]){
                    return false;
                }
            }
        }   

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(!bfs(graph,i,color,q)){
                    return false;
                }
            }
        }

        return true;
 
    }
}
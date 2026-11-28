class Solution {
     boolean bfs(List<List<Integer>> adj,int src,int color[],Queue<Integer> q){
        q.add(src);
        color[src] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neigh : adj.get(node)){
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<dislikes.length;i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int color[] = new int[n+1];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1;i<=n;i++){
            if(color[i] == -1){
                if(!bfs(adj,i,color,q)){
                    return false;
                }
            }
        }

        return true;
    }
}
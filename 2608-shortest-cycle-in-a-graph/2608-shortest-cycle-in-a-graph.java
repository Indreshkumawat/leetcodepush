class Solution {
    int minDist = Integer.MAX_VALUE;
    void bfs(List<List<Integer>> adj,int dist[],boolean visited[],int parent[],Queue<Integer> q,int src){
        q.add(src);
        visited[src] = true;
        dist[src] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int s : adj.get(node)){
                if(!visited[s]){
                    parent[s] = node;
                    visited[s] = true;
                    q.add(s);
                    dist[s] = dist[node]+1;
                }else{
                    if(s != parent[node]){
                        int distance = dist[s] + dist[node] + 1; 
                        minDist = Math.min(minDist,distance);
                    }
                }
            }
        }

    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        int dist[] = new int[n];
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];

        Arrays.fill(parent,-1);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            bfs(adj,dist,visited,parent,q,i);
            Arrays.fill(dist,0);
            Arrays.fill(visited,false);
            Arrays.fill(parent,-1);
            q.clear();
        }
        return minDist != Integer.MAX_VALUE ? minDist : -1;
    }
}
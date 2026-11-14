class Solution {
    int dfs(List<List<Integer>> adj,int src,int des,int n){
         boolean[] visited = new boolean[n + 1];

    int[] distance = new int[n + 1];
    Arrays.fill(distance, -1);

    Queue<Integer> q = new LinkedList<>();

    visited[src] = true;
    distance[src] = 0;

    q.add(src);

    while (!q.isEmpty()) {

        int node = q.poll();

        if (node == des) {
            return distance[node];
        }

        for (int s : adj.get(node)) {

            if (!visited[s]) {

                visited[s] = true;

                distance[s] = distance[node] + 1;

                q.add(s);
            }
        }
    }

    return -1;
    }
    public int[] countOfPairs(int n, int x, int y) {
        int ans[] = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1;i<n;i++){
            adj.get(i).add(i+1);
            adj.get(i+1).add(i);
        }

        adj.get(x).add(y);
        adj.get(y).add(x);

        for(int i = 1;i<n;i++){
            for(int j = i+1;j<=n;j++){
                int minCount = dfs(adj,i,j,n);
                ans[minCount-1] += 2;
            }
        }

        return ans;
    }
}
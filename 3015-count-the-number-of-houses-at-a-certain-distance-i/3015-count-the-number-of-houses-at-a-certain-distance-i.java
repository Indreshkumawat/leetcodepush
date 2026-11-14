class Solution {
    void bfs(List<List<Integer>> adj, int src,
             int[] ans, int n) {

        boolean[] visited = new boolean[n + 1];

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;
        distance[src] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    distance[neighbor] =
                        distance[node] + 1;

                    q.add(neighbor);
                }
            }
        }

        for (int i = src + 1; i <= n; i++) {

            ans[distance[i] - 1] += 2;
        }
    }

    public int[] countOfPairs(int n, int x, int y) {

        int[] ans = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            adj.get(i).add(i + 1);
            adj.get(i + 1).add(i);
        }

        adj.get(x).add(y);
        adj.get(y).add(x);

        for (int i = 1; i <= n; i++) {
            bfs(adj, i, ans, n);
        }

        return ans;
    }
}
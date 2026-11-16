class Solution {
    class Pair {
        int y;
        int color;

        Pair(int y, int c) {
            this.y = y;
            this.color = c;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int ans[] = new int[n];
        Arrays.fill(ans,-1);

        List<List<Pair>> adj = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<redEdges.length;i++){
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            adj.get(u).add(new Pair(v,0));
        }
        for(int i = 0;i<blueEdges.length;i++){
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adj.get(u).add(new Pair(v,1));
        }

        q.add(new Pair(0,-1));
        visited[0][0] = true;
        visited[0][1] = true;;
        ans[0] = 0;
        int distance = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                Pair node = q.poll();
                int src = node.y;
                int color = node.color;

                for(Pair p : adj.get(src)){
                    if (color == -1 || p.color != color) {

                        if (!visited[p.y][p.color]) {

                            visited[p.y][p.color] = true;

                            q.add(new Pair(p.y, p.color));

                            if (ans[p.y] == -1) {
                                ans[p.y] = distance + 1;
                            }
                        }
                    }
                }
                size--;
            }
            distance++;
        }
    return ans;    
    }
}
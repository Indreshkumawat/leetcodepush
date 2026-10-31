class Solution {
    int ans = 0;
    boolean visited[]; 
    int visitedTime[];
    int visitedRun[];

    void dfs(int[] edges,int currentRun,int steps,int src){

        if(visited[src]){
            if(visitedRun[src] == currentRun){
                ans = Math.max(ans,steps-visitedTime[src]);
            }
            return; 
        }
        if(edges[src] == -1){
            return;
        }
        visited[src] = true;
        visitedTime[src] = steps;
        visitedRun[src] = currentRun;
        dfs(edges,currentRun,steps+1,edges[src]);
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;

        visited = new boolean[n];
        visitedTime = new int[n];
        visitedRun = new int[n];

        Arrays.fill(visitedTime,-1);

        int currentRun = 0;
        int steps = 0;

        for (int i = 0; i < n; i++) {
            currentRun++;
            if (!visited[i] && edges[i] != -1)
                dfs(edges, currentRun, steps, i);
        }

        return ans != 0 ? ans : -1;

    }
}
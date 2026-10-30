class Solution {
    void dfs(List<List<Integer>> rooms,int src,boolean visited[]){
        visited[src] = true;
        List<Integer> temp = rooms.get(src);
        for(int i = 0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                dfs(rooms,temp.get(i),visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms,0,visited);

        for(int i = 0;i<visited.length;i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }
}
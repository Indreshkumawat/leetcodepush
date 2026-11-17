class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x <= y){
            return y - x;
        }
        boolean visited[] = new boolean[2*x+1];

        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        visited[x] = true;
        int op = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int val = q.poll();

                if(val == y){
                    return op;
                }

                if(val%11 == 0 && !visited[val/11]){
                    visited[val/11] = true;
                    q.add(val/11);
                }
                if(val%5 == 0 && !visited[val/5]){
                    visited[val/5] = true;
                    q.add(val/5);
                }
                if(val > 0 && !visited[val-1]){
                    visited[val-1] = true;
                    q.add(val-1);
                }
                if(val < 2*x && !visited[val+1]){
                    visited[val+1] = true;
                    q.add(val+1);
                }

                size--;
            }

            op++;

        }

        return -1;
    }
}
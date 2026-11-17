class Solution {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[arr.length];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int index = q.poll();

            if(arr[index] == 0){
                return true;
            }

            int plus = index + arr[index];
            int minus = index - arr[index];

            if(plus < arr.length && !visited[plus]){
                visited[plus] = true;
                q.add(plus);

            }
            if(minus >= 0 && !visited[minus]){
                visited[minus] = true;
               q.add(minus); 
            }
        }

        return false;
    }
}
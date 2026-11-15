class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {

        if (start == goal) {
            return 0;
        }
        int x = start;

        Queue<Integer> q = new LinkedList<>();

        boolean visited[] = new boolean[1001];

        q.add(x);
        visited[x] = true;

        int ans = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size > 0) {
                int val = q.poll();
                for (int i : nums) {
                    int plus = val + i;
                    int minus = val - i;
                    int xor = val ^ i;

                    if (plus == goal || minus == goal || xor == goal) {
                        return ans + 1;
                    }

                    if (plus >= 0 && plus <= 1000 && !visited[plus]) {
                        q.add(plus);
                        visited[plus] = true;
                    }
                    if (minus >= 0 && minus <= 1000 && !visited[minus]) {
                        q.add(minus);
                        visited[minus] = true;
                    }
                    if (xor >= 0 && xor <= 1000 && !visited[xor]) {
                        q.add(xor);
                        visited[xor] = true;
                    }
                }
                size--;
            }
            ans++;
        }

        return -1;
    }
}
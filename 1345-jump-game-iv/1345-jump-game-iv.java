class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());

            mp.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                int index = q.poll();

                if (index == n - 1) {
                    return ans;
                }

                if (mp.containsKey(arr[index])) {
                    for (int i : mp.get(arr[index])) {
                        if (!visited[i]) {
                            q.add(i);
                            visited[i] = true;
                        }
                    }
                    mp.remove(arr[index]);
                }

                if (index + 1 < n && !visited[index + 1]) {
                    q.add(index + 1);
                    visited[index + 1] = true;
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    q.add(index - 1);
                    visited[index - 1] = true;
                }

                size--;

            }

            ans++;
        }

        return ans;
    }
}
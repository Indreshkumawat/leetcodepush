class Solution {
    int[] getCords(int val, int n) {
        int ans[] = new int[2];

        int row = (n - 1) - (val - 1) / n;
        int col = (val - 1) % n;

        if ((n % 2 == 0 && row % 2 == 0) || (n % 2 != 0 && row % 2 != 0)) {
            col = (n - 1) - (val - 1) % n;
        }
        ans[0] = row;
        ans[1] = col;
        return ans;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean visited[][] = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        int steps = 0;

        q.add(1);
        visited[n - 1][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {

                int x = q.poll();

                if (x == n * n) {
                    return steps;
                }

                for (int i = 1; i <= 6; i++) {

                    int val = x + i;

                    if (val > n * n) {
                        break;
                    }

                    int[] cord = getCords(val, n);

                    int r = cord[0];
                    int c = cord[1];

                    int destination = board[r][c] == -1
                                      ? val
                                      : board[r][c];

                    int[] destCord = getCords(destination, n);

                    int destRow = destCord[0];
                    int destCol = destCord[1];

                    if (!visited[destRow][destCol]) {

                        visited[destRow][destCol] = true;

                        q.add(destination);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
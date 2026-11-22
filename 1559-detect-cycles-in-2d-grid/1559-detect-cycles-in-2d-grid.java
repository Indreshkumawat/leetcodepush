class Solution {
    int[] dx;
    int[] dy;
    int m;
    int n;

    boolean dfs(char[][] grid, int x, int y,int parentX,int parentY,boolean visited[][]) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == grid[x][y]) {
                if (!visited[nx][ny]) {
                    if (dfs(grid, nx, ny,x,y, visited))
                        return true;
                } else if (nx != parentX && ny != parentY) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        dx = new int[] { 0, 0, 1, -1 };
        dy = new int[] { 1, -1, 0, 0 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {

                    if (dfs(grid, i, j, -1, -1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class Solution {
    int[][] grid;
    int[][][] memo;
    int m, n;

    int find(int i, int j, int dir) {
        if (memo[i][j][dir] != -2) {
            return memo[i][j][dir];
        }

        int r = i;
        int c = j;
        int nextDir;

        if (dir == 0) {
            r++;
            nextDir = 1;
        } else {
            c++;
            nextDir = 0;
        }

        if (r >= m || c >= n) {
            return memo[i][j][dir] = -1;
        }

        if (grid[r][c] == 1) {
            return memo[i][j][dir] = find(r, c, nextDir);
        }

        return memo[i][j][dir] = r * n + c;
    }

    int get(int i, int j, int dir) {
        if (i >= m || j >= n) {
            return -1;
        }

        if (grid[i][j] == 1) {
            return find(i, j, dir);
        }

        return i * n + j;
    }

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        int[][] dp = new int[m][n];
        int mod = 1000000007;

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 || dp[i][j] == 0) {
                    continue;
                }

                int right = get(i, j + 1, 0);

                if (right != -1) {
                    int r = right / n;
                    int c = right % n;

                    dp[r][c] = (int)((dp[r][c] + (long)dp[i][j]) % mod);
                }

                int down = get(i + 1, j, 1);

                if (down != -1) {
                    int r = down / n;
                    int c = down % n;

                    dp[r][c] = (int)((dp[r][c] + (long)dp[i][j]) % mod);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

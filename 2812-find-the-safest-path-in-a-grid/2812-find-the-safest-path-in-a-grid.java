import java.util.*;

class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // ⭐ EDGE CASE FIX
        if (n == 1) return 0;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int safe = cur[0], r = cur[1], c = cur[2];

            if (r == n - 1 && c == n - 1)
                return safe;

            if (vis[r][c]) continue;
            vis[r][c] = true;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !vis[nr][nc]) {

                    int newSafe = Math.min(safe, dist[nr][nc]);
                    pq.offer(new int[]{newSafe, nr, nc});
                }
            }
        }

        return 0;
    }
}
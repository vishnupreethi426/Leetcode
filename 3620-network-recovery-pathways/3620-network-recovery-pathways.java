import java.util.*;

class Solution {
    List<int[]>[] g;
    int[] topo;
    boolean[] on;
    long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        this.k = k;
        this.on = online;

        g = new ArrayList[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        int hi = 0;
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            hi = Math.max(hi, e[2]);
        }

        topo = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.offer(i);

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : g[u]) {
                if (--indegree[e[0]] == 0)
                    q.offer(e[0]);
            }
        }

        int l = 0, r = hi, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, n)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int x, int n) {
        long INF = Long.MAX_VALUE / 2;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;
            if (u != 0 && u != n - 1 && !on[u]) continue;

            for (int[] e : g[u]) {
                int v = e[0], w = e[1];

                if (w < x) continue;
                if (v != n - 1 && !on[v]) continue;

                if (dist[v] > dist[u] + w)
                    dist[v] = dist[u] + w;
            }
        }

        return dist[n - 1] <= k;
    }
}
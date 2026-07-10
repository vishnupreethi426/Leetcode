class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));

        int[] pos = new int[n], reach = new int[n];
        for (int i = 0; i < n; i++) pos[a[i][1]] = i;

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && a[j + 1][0] - a[i][0] <= maxDiff) j++;
            reach[i] = j;
        }

        int LOG = 18;
        int[][] up = new int[LOG][n];
        up[0] = reach.clone();

        for (int k = 1; k < LOG; k++)
            for (int i = 0; i < n; i++)
                up[k][i] = up[k - 1][up[k - 1][i]];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]], v = pos[queries[i][1]];
            if (u == v) continue;
            if (u > v) { int t = u; u = v; v = t; }

            int cur = u, step = 0;
            for (int k = LOG - 1; k >= 0; k--)
                if (up[k][cur] < v) {
                    step += 1 << k;
                    cur = up[k][cur];
                }

            cur = reach[cur];
            ans[i] = cur >= v ? step + 1 : -1;
        }
        return ans;
    }
}
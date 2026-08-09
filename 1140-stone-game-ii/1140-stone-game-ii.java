class Solution {
    int[][] dp;
    int[] sum;

    public int stoneGameII(int[] p) {
        int n = p.length;
        dp = new int[n][n + 1];
        sum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--)
            sum[i] = sum[i + 1] + p[i];

        return f(p, 0, 1);
    }

    int f(int[] p, int i, int m) {
        if (i >= p.length) return 0;
        if (dp[i][m] != 0) return dp[i][m];

        int ans = 0;
        for (int x = 1; x <= 2 * m && i + x <= p.length; x++)
            ans = Math.max(ans, sum[i] - f(p, i + x, Math.max(m, x)));

        return dp[i][m] = ans;
    }
}
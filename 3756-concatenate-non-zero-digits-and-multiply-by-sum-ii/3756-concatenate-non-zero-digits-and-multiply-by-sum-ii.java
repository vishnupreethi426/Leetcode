class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1000000007L;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> val = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                val.add(d);
            }
        }

        int n = pos.size();

        long[] preNum = new long[n + 1];
        long[] preSum = new long[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;

        for (int i = 0; i < n; i++) {
            preNum[i + 1] = (preNum[i] * 10 + val.get(i)) % MOD;
            preSum[i + 1] = preSum[i] + val.get(i);
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long x = preNum[right + 1]
                    - (preNum[left] * pow10[right - left + 1]) % MOD;

            x = (x + MOD) % MOD;

            long sum = preSum[right + 1] - preSum[left];

            ans[i] = (int)((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int dp1 = 0, dp2 = 0, dp3 = 0, curr = 0;

        for (int i = n - 1; i >= 0; i--) {
            curr = Integer.MIN_VALUE;
            int sum = 0;

            sum += stoneValue[i];
            curr = Math.max(curr, sum - dp1);

            if (i + 1 < n) {
                sum += stoneValue[i + 1];
                curr = Math.max(curr, sum - dp2);
            }

            if (i + 2 < n) {
                sum += stoneValue[i + 2];
                curr = Math.max(curr, sum - dp3);
            }

            dp3 = dp2;
            dp2 = dp1;
            dp1 = curr;
        }

        if (dp1 > 0) return "Alice";
        if (dp1 < 0) return "Bob";
        return "Tie";
    }
}
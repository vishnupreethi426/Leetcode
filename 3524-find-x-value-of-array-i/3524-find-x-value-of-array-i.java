class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            // Start a new subarray
            next[num % k]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int newR = (int)((r * (long)(num % k)) % k);
                next[newR] += dp[r];
            }

            // Add subarrays ending here to the answer
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}
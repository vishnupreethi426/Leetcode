class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long k = (long) k1 + k2;
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (k >= total) {
            return 0;
        }

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long need = 0;

            for (int d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long sum = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, left);
            used += d - reduced;
            sum += (long) reduced * reduced;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining == 0) {
                break;
            }

            if (d >= left && d > 0) {
                sum -= (long) left * left;
                sum += (long) (left - 1) * (left - 1);
                remaining--;
            }
        }

        return sum;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int m = a.length;
        int n = b.length;

        int low = 0, high = m;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : a[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1)
                    return Math.max(l1, l2);

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }

        return 0.0;
    }
}
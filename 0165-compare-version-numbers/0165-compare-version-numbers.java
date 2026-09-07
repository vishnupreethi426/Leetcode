class Solution {
    public int compareVersion(String version1, String version2) {

        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");

        int n = Math.max(a.length, b.length);

        for (int i = 0; i < n; i++) {

            int x = 0;
            int y = 0;

            if (i < a.length) {
                x = Integer.parseInt(a[i]);
            }

            if (i < b.length) {
                y = Integer.parseInt(b[i]);
            }

            if (x < y) {
                return -1;
            }

            if (x > y) {
                return 1;
            }
        }

        return 0;
    }
}
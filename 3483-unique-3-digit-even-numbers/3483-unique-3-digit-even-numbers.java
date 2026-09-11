class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        for (int i = 100; i <= 999; i++) {
            if (i % 2 != 0) continue;

            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            int[] f = new int[10];

            for (int d : digits)
                f[d]++;

            if (f[a] > 0) {
                f[a]--;
                if (f[b] > 0) {
                    f[b]--;
                    if (f[c] > 0)
                        count++;
                }
            }
        }

        return count;
    }
}
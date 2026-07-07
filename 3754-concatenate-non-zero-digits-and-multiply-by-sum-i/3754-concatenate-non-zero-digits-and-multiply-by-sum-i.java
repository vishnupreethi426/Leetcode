class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, p = 1;
        int sum = 0;

        while (n!=0) {
            int digits = n % 10;
            if (digits != 0) {
                x = digits * p + x;
                p *= 10;
                sum += digits;
            }
            n /= 10;
        }

        return x * sum;
    }
}
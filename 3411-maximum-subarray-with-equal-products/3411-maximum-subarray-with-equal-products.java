
class Solution {
    public int maxLength(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            long product = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < nums.length; j++) {

                product *= nums[j];

                gcd = findGCD(gcd, nums[j]);

                lcm = (lcm * nums[j]) / findGCD(lcm, nums[j]);

                if (product == gcd * lcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public long findGCD(long a, long b) {

        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }
}

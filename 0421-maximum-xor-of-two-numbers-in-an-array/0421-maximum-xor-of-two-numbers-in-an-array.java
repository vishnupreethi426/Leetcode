class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int mask = max | (1 << bit);

            java.util.HashSet<Integer> set = new java.util.HashSet<>();

            for (int num : nums) {
                set.add(num & mask);
            }

            for (int num : nums) {
                int prefix = num & mask;

                if (set.contains(prefix ^ mask)) {
                    max = mask;
                    break;
                }
            }
        }

        return max;
    }
}
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        boolean[] seen = new boolean[101];

        for (int x : nums) seen[x] = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                sum += nums[i];
            else
                break;
        }

        while (sum <= 100 && seen[sum])
            sum++;

        return sum;
    }
}
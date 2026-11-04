import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int n = num;

                while (set.contains(n + 1)) {
                    count++;
                    n++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
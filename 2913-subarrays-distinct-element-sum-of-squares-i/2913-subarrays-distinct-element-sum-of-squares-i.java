import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            boolean[] seen = new boolean[101];
            int count = 0;

            for (int j = i; j < nums.size(); j++) {
                if (!seen[nums.get(j)]) {
                    count++;
                    seen[nums.get(j)] = true;
                }

                sum += count * count;
            }
        }

        return sum;
    }
}

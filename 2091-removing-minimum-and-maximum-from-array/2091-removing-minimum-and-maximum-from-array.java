import java.util.*;

class Solution {
    public int minimumDeletions(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int x : nums) {
            arr.add(x);
        }

        int min = Collections.min(arr);
        int max = Collections.max(arr);

        int minIndex = arr.indexOf(min);
        int maxIndex = arr.indexOf(max);

        int n = nums.length;

        // minIndex and maxIndex: first/last positions
        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);

        int both = Math.min(minIndex, maxIndex) + 1
                 + n - Math.max(minIndex, maxIndex);

        return Math.min(left, Math.min(right, both));
    }
}
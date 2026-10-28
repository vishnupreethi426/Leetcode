
class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];

        for (char c : t.toCharArray())
            freq[c]++;

        int left = 0, count = t.length();
        int min = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)]-- > 0)
                count--;

            while (count == 0) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                if (++freq[s.charAt(left++)] > 0)
                    count++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}

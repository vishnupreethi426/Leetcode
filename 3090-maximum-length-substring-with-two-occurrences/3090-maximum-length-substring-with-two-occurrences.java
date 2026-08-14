class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                count[index]++;
                if (count[index] > 2) {
                    break;
                }
                int length = j - i + 1;
                max = Math.max(max, length);
            }
        }

        return max;
    }
}
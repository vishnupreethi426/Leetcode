
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            String sub = "";

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                if (sub.contains(String.valueOf(ch))) {
                    break;
                }

                sub = sub + ch;

                max = Math.max(max, sub.length());
            }
        }

        return max;
    }
}

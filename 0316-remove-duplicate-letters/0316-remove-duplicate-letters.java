class Solution {
    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        boolean[] used = new boolean[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            count[ch - 'a']--;

            if (used[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   count[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char last = stack.charAt(stack.length() - 1);
                used[last - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(ch);
            used[ch - 'a'] = true;
        }

        return stack.toString();
    }
}
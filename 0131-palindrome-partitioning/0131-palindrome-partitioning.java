import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generate(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void generate(String s, int start,
                          List<String> current,
                          List<List<String>> result) {

        // If all characters are used
        if (start == s.length()) {

            // Check whether the complete partition is valid
            boolean valid = true;

            for (String str : current) {
                if (!isPalindrome(str)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            current.add(s.substring(start, end + 1));

            generate(s, end + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
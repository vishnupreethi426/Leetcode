import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        HashMap<Object, Object> seen = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String keyP = "p" + pattern.charAt(i);
            String keyW = "w" + words[i];

            if (seen.containsKey(keyP) && !seen.get(keyP).equals(words[i]))
                return false;

            if (seen.containsKey(keyW) && !seen.get(keyW).equals(pattern.charAt(i)))
                return false;

            seen.put(keyP, words[i]);
            seen.put(keyW, pattern.charAt(i));
        }

        return true;
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {

            int left = i;
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (!map.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > map.get(word)) {

                    String leftWord = s.substring(left, left + wordLength);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += wordLength;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLength);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += wordLength;
                    count--;
                }
            }
        }

        return result;
    }
}

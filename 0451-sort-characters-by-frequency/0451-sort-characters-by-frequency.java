class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[256];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        StringBuilder result = new StringBuilder();

        // Find highest frequency
        for (int count = s.length(); count > 0; count--) {

            for (int i = 0; i < 256; i++) {

                if (freq[i] == count) {

                    for (int j = 0; j < count; j++) {
                        result.append((char) i);
                    }

                    freq[i] = 0;
                }
            }
        }

        return result.toString();
    }
}
class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        for (int num = 100; num <= 999; num++) {

            // Number must be even
            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] temp = new int[10];

            // Count digits available in input
            for (int digit : digits) {
                temp[digit]++;
            }

            // Use one copy of each digit
            temp[a]--;
            temp[b]--;
            temp[c]--;

            if (temp[a] >= 0 && temp[b] >= 0 && temp[c] >= 0) {
                count++;
            }
        }

        return count;
    }
}

class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;

        while (n >= stones) {
            n = n - stones;
            stones--;

            if (stones == 0) {
                break;
            }
        }

        return stones % 2 == 1;
    }
}

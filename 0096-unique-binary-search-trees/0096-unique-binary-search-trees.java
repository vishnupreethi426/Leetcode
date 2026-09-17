class Solution {
    public int numTrees(int n) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * (n + i) / i;
        }

        return (int)(ans / (n + 1));
    }
}
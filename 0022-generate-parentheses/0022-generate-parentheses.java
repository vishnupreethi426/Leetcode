class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack("", 0, 0, n, result);

        return result;
    }

    public void backtrack(String s, int open, int close, int n, List<String> result) {

        // Complete valid string
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(s + "(", open + 1, close, n, result);
        }

        // Add closing bracket
        if (close < open) {
            backtrack(s + ")", open, close + 1, n, result);
        }
    }
}
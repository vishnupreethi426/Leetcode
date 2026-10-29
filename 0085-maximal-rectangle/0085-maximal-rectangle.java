
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            int[] stack = new int[cols + 1];
            int top = -1;

            for (int j = 0; j <= cols; j++) {
                int h = (j == cols) ? 0 : height[j];

                while (top >= 0 && height[stack[top]] > h) {
                    int ht = height[stack[top--]];
                    int width = (top == -1) ? j : j - stack[top] - 1;
                    max = Math.max(max, ht * width);
                }

                stack[++top] = j;
            }
        }

        return max;
    }
}

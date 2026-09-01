class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        // Perform shift k times
        for (int x = 0; x < k; x++) {

            // Save last element
            int last = grid[m - 1][n - 1];

            // Shift elements
            for (int i = m - 1; i >= 0; i--) {

                // Shift current row to the right
                for (int j = n - 1; j >= 1; j--) {
                    grid[i][j] = grid[i][j - 1];
                }

                // First element gets previous row's last element
                if (i > 0) {
                    grid[i][0] = grid[i - 1][n - 1];
                }
            }

            // Last element goes to [0][0]
            grid[0][0] = last;
        }

        // Convert int[][] to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}
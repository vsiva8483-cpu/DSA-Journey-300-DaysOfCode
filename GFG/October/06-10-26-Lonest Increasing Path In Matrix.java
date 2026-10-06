class Solution {

    public int longIncPath(int[][] matrix, int n, int m) {

        int[][] dp = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, dp, i, j, n, m));
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int[][] dp,
                   int i, int j, int n, int m) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int best = 1;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, i - 1, j, n, m));
        }
        if (i < n - 1 && matrix[i + 1][j] > matrix[i][j]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, i + 1, j, n, m));
        }

        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, i, j - 1, n, m));
        }

        if (j < m - 1 && matrix[i][j + 1] > matrix[i][j]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, i, j + 1, n, m));
        }

        dp[i][j] = best;

        return best;
    }
}

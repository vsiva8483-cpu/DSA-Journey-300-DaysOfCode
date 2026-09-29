class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        dp = new Boolean[m][n][m + n + 1];

        return dfs(0, 0, 0);
    }

    boolean dfs(int r, int c, int balance) {
        if (r >= m || c >= n)
            return false;

        if (grid[r][c] == '(')
            balance++;
        else
            balance--;

        if (balance < 0)
            return false;

        if (r == m - 1 && c == n - 1)
            return balance == 0;

        if (dp[r][c][balance] != null)
            return dp[r][c][balance];

        boolean right = dfs(r, c + 1, balance);
        boolean down = dfs(r + 1, c, balance);

        return dp[r][c][balance] = right || down;
    }
}

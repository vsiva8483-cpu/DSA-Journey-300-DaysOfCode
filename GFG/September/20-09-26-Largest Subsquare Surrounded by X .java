class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length, ans = 0;
        int[][] r = new int[n][n + 1];
        int[][] c = new int[n + 1][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                r[i][j + 1] = r[i][j] + (mat[i][j] == 'X' ? 1 : 0);
                c[i + 1][j] = c[i][j] + (mat[i][j] == 'X' ? 1 : 0);
            }

        for (int k = n; k > 0; k--)
            for (int i = 0; i + k <= n; i++)
                for (int j = 0; j + k <= n; j++) {
                    int x = i + k - 1, y = j + k - 1;
                    if (r[i][y+1]-r[i][j] == k &&
                        r[x][y+1]-r[x][j] == k &&
                        c[x+1][j]-c[i][j] == k &&
                        c[x+1][y]-c[i][y] == k)
                        return k;
                }
        return 0;
    }
}

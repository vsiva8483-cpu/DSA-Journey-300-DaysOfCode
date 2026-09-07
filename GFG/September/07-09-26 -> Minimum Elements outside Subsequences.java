class Solution {
    public int minCount(int[] a) {
        int n = a.length;
        int[][][] d = new int[n + 1][n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--)
            for (int x = -1; x < n; x++)
                for (int y = -1; y < n; y++) {
                    d[i][x + 1][y + 1] = 1 + d[i + 1][x + 1][y + 1];

                    if (x < 0 || a[i] > a[x])
                        d[i][x + 1][y + 1] =
                            Math.min(d[i][x + 1][y + 1], d[i + 1][i + 1][y + 1]);

                    if (y < 0 || a[i] < a[y])
                        d[i][x + 1][y + 1] =
                            Math.min(d[i][x + 1][y + 1], d[i + 1][x + 1][i + 1]);
                }

        return d[0][0][0];
    }
}

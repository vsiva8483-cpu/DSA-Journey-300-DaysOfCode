import java.util.*;

class Solution {
    static class S {
        long w;
        int[] a;
        S(long w, int[] a) { this.w = w; this.a = a; }
    }

    public int[] maximumWeight(List<List<Integer>> in) {
        int n = in.size();
        int[][] x = new int[n][4];

        for (int i = 0; i < n; i++) {
            x[i][0] = in.get(i).get(0);
            x[i][1] = in.get(i).get(1);
            x[i][2] = in.get(i).get(2);
            x[i][3] = i;
        }

        Arrays.sort(x, (a,b) -> a[1] != b[1] ?
                Integer.compare(a[1],b[1]) :
                Integer.compare(a[3],b[3]));

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (x[m][1] < x[i][0]) l = m + 1;
                else r = m - 1;
            }
            p[i] = l;
        }

        S[][] dp = new S[5][n + 1];
        for (int k = 0; k <= 4; k++)
            for (int i = 0; i <= n; i++)
                dp[k][i] = new S(0, new int[0]);

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 4; k++) {
                S skip = dp[k][i - 1];
                S old = dp[k - 1][p[i - 1]];

                int[] b = Arrays.copyOf(old.a, old.a.length + 1);
                b[b.length - 1] = x[i - 1][3];
                Arrays.sort(b);

                S take = new S(old.w + x[i - 1][2], b);

                dp[k][i] = better(skip, take);
            }
        }

        return dp[4][n].a;
    }

    static S better(S a, S b) {
        if (a.w != b.w)
            return a.w > b.w ? a : b;

        for (int i = 0; i < Math.min(a.a.length, b.a.length); i++)
            if (a.a[i] != b.a[i])
                return a.a[i] < b.a[i] ? a : b;

        return a.a.length <= b.a.length ? a : b;
    }
}

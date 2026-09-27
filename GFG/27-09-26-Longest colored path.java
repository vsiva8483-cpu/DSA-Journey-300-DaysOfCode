import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }

        int[] par = new int[n], order = new int[n];
        Arrays.fill(par, -2);
        par[0] = -1;
        int size = 1;
        order[0] = 0;

        for (int i = 0; i < size; i++) {
            int u = order[i];
            for (int v : g[u]) {
                if (v != par[u]) {
                    par[v] = u;
                    order[size++] = v;
                }
            }
        }

        int[] dp0 = new int[n], dp1 = new int[n];
        int ans = 1;

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int best0 = 1, best1 = 0;

            for (int v : g[u]) {
                if (par[v] != u) continue;

                int c0 = 0, c1 = 0;

                if (s.charAt(u) == s.charAt(v)) {
                    c0 = 1 + dp0[v];
                    if (dp1[v] > 0) c1 = 1 + dp1[v];
                } else {
                    c1 = 1 + dp0[v];
                }

                if (c0 > 0) {
                    ans = Math.max(ans, c0 + best0 - 1);
                    if (best1 > 0)
                        ans = Math.max(ans, c0 + best1 - 1);
                }

                if (c1 > 0)
                    ans = Math.max(ans, c1 + best0 - 1);

                best0 = Math.max(best0, c0);
                best1 = Math.max(best1, c1);
            }

            dp0[u] = best0;
            dp1[u] = best1;
        }

        return ans;
    }
}

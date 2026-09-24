import java.util.*;

class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        ArrayList<Integer>[] a = new ArrayList[1001];

        for (int i = 1; i <= 1000; i++)
            a[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            a[r[i]].add(i);

        int[] bit = new int[1001];
        int ans = 0;

        for (int rad = 1; rad <= 1000; rad++) {
            int[] dp = new int[a[rad].size()];
            int k = 0;

            for (int i : a[rad]) {
                int best = 0;
                for (int x = h[i] - 1; x > 0; x -= x & -x)
                    best = Math.max(best, bit[x]);

                dp[k++] = best + h[i];
                ans = Math.max(ans, best + h[i]);
            }

            k = 0;
            for (int i : a[rad]) {
                for (int x = h[i]; x <= 1000; x += x & -x)
                    bit[x] = Math.max(bit[x], dp[k]);
                k++;
            }
        }

        return ans;
    }
}

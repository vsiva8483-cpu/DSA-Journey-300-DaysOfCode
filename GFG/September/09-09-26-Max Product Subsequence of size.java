class Solution {
    public int maxProduct(int[] a, int k) {
        long[] mx = new long[k + 1];
        long[] mn = new long[k + 1];

        java.util.Arrays.fill(mx, Long.MIN_VALUE);
        java.util.Arrays.fill(mn, Long.MAX_VALUE);

        mx[0] = mn[0] = 1;

        for (int x : a) {
            for (int j = k; j >= 1; j--) {
                if (mx[j - 1] == Long.MIN_VALUE) continue;

                long p = mx[j - 1] * x;
                long q = mn[j - 1] * x;

                mx[j] = Math.max(mx[j], Math.max(p, q));
                mn[j] = Math.min(mn[j], Math.min(p, q));
            }
        }

        return (int) mx[k];
    }
}

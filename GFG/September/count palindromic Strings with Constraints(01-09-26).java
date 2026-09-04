class Solution {
    public int palindromicStrings(int n, int k) {
        long ans = 0;
        long mod = 1000000007;

        for (int len = 1; len <= n; len++) {
            int half = (len + 1) / 2;

            if (half <= k) {
                long ways = 1;

                for (int i = 0; i < half; i++) {
                    ways = ways * (k - i) % mod;
                }

                ans = (ans + ways) % mod;
            }
        }

        return (int) ans;
    }
}

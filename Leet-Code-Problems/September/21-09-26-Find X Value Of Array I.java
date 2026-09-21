class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            int val = num % k;
            next[val]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newR = (r * val) % k;
                    next[newR] += dp[r];
                }
            }

            dp = next;
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}
